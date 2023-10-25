let express = require('express');
let app = express();

// app - 서버임

// 미들웨어 - 중간에서 가로채서 처리를 하는 함수
// 서블릿 -> 상속 써서
app.use("/a", function(req, res) {
    res.writeHead(200, {"Content-Type":"text-html"});
    res.end("<h1>This is A</h1>");
});

// 부가적인 정보가 전달되면
/*
get         -- 과거 : add?x=5&y=7
get2        -- 현재(바뀐지 오래됨) path variable : add/5/7 
post        -- add body 부분 : x-www-form-urlencoded, form-data(multipart) 파일전송, json(ajax)

get1 -> req.query.x, req.query.y

app.use("/add/:x/:y")
get2 -> req.params.x, req.params.y

post -> body.parser를 이용한다. 과거에는 직접 설치하고 미들웨어 연결
    app.use(express.urlencoded({ extended : false}));    기술해주면
    req.body.파라미터명
*/


// Post 처리를 하기 위한 코드
app.use(express.urlencoded({ extended : false}));

app.use("/add", function(req, res) {
    let x = parseInt( req.query.x );
    let y = parseInt( req.query.y );
    let result = x+y;
    res.writeHead(200, {"Content-Type":"text-html"});
    res.end(`<h1>${x} + ${y} = ${result}</h1>`);
});

app.use("/add2/:x/:y", function(req, res) {
    let x = parseInt( req.params.x );
    let y = parseInt( req.params.y );
    let result = x+y;
    res.writeHead(200, {"Content-Type":"text-html"});
    res.end(`<h1>************ ${x} + ${y} = ${result} *******</h1>`);
});

app.use("/add_post", function(req, res) {
    let x = parseInt( req.body.x );
    let y = parseInt( req.body.y );
    let result = x+y;
    res.writeHead(200, {"Content-Type":"text-html"});
    res.end(`<h1>==== ${x} + ${y} = ${result} ====</h1>`);
});

// 적당하지 않은 url 처리를 이 함수내에서 해야 한다.
// 모든 url에 대해서 이 함수가 처리를 한다.
app.use( function(req, res) {
    res.writeHead(200, {"Content-Type":"text-html"});
    res.end("<h1>Hello express</h1>");
});

app.listen(4000, ()=>{
    console.log("server start at http://127.0.0.1:4000");
});