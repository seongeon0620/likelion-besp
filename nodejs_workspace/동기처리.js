// 동기처리.js
// 변수 선언이 없다. 그래도 선언하고싶다면 var 또는 let 사용
// var - old 버전, let - new 버전, 가급적 let을 사용한다.
// var - 호이스팅 문제가 발생, 변수가 스코프룰처리가 안된다.
let fs = require("fs"); // 외부에 있는 fs모듈을 사용하겠다
// 자바스크립트로 파일을 읽는다. readFile, readFileSync가 있다.
// readFile - 비동기 모드 readFileSynce - 동기모드
let result = fs.readFileSync("./test.txt", encode = "utf-8");
console.log(result);
console.log("완료--------");