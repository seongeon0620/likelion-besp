var express = require("express");
var router = express.Router();

boardList = [
    {"id":1,"title":"쌍갑포차1", "writer":"글쓴이1", "contents":"내용1", "wdate":"2023-10-25"},
    {"id":2,"title":"쌍갑포차2", "writer":"글쓴이3", "contents":"내용입니다", "wdate":"2023-10-25"},
    {"id":3,"title":"쌍갑포차3", "writer":"글쓴이4", "contents":"내용~~", "wdate":"2023-10-25"},
    {"id":4,"title":"쌍갑포차4", "writer":"글쓴이5", "contents":"내용^%^1", "wdate":"2023-10-25"},
    {"id":5,"title":"쌍갑포차5", "writer":"글쓴이6", "contents":"내용5451", "wdate":"2023-10-25"}
];

// app.js /board => 이 파일을 부르도록
// /board/list, /board/view/:id, /board/write, /board/save
router.get('/list', function(req, res) {
    res.render('board/board_list', {"boardList":boardList});
});

router.get("/view/:id", (req, res) => {
    // filter를 거치면 배열형태라서 0번째 것만 전송한다.
    let id = req.params.id;
    let board = boardList.filter( item => item.id == id )[0];
    res.render("board/board_view", {"board": board});
});

router.get("/write", (req, res) => {
    res.render("board/board_write");
});

router.post("/save", (req, res) => {
    let id = boardList.length + 1;
    let title = req.body.title;
    let contents = req.body.contents;
    let writer = req.body.writer;

    boardList.push( {"id":id, "title":title, "writer":writer, "contents":contents, "wdate":"2023-10-25"});

    res.send({"result":"success"});
});

// 각각 파일이 독립되면 각 파일 내의 코드는 독립이라 외부에서 접근이 안된다.
// 아래의 명령어를 통해 외부 접근이 가능해짐.
module.exports = router;