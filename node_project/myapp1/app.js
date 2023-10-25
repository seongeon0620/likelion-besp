var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');  // 쿠키사용
var logger = require('morgan'); // log

// 외부파일을 가져온다 - 경로배정(스프링의 controller)
var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var boardRouter = require('./routes/board');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);  // / ~시작하면 indexRoutor가 처리
app.use('/users', usersRouter); // /users 시작하면 usersRouter가 처리
app.use('/board', boardRouter); // /board 시작하면 routes/board.js가 처리
// npm start => 코드가 바뀐것을 반영하지 않는다
// nodemon : npm install -g nodemon : vscode의 터미널에선 실행안됨 (코드를 감시하므로 반영시킴)

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
