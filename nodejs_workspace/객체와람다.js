// JSON => 자바의 HashMap, 파이썬 Dict, C# Dict
// 배열은 인덱스로 값에 접근, JSON은 키와 값 쌍으로 저장하여 키를 이용한 접근방식
// 키와 값 쌍의 형태로 저장한다. {"키1":"값1", "키2":"값2"}, 키값은 문자열이나 Symbol 타입만 가능하다. 키값에 하이픈 사용 불가능
// 값타입은 아무거나 심지어 함수도 저장함
// 자바스크립트는 키 값에 "", '', 혹은 아무것도 붙이지 않아도 가능하다. 
// 백과 프론트가 데이터를 주고받을 때 JSON 형태로 주고 받음. 그러나 형태가 JSON 형태인거지 실제 JSON 객체는 아님.
let person = {
    "name" : "홍길동",
    "age" : 21,
    "phone" : "010-0000-0000"
};
console.log( person.name );
console.log( person["name"]);

// 객체배열
let persons = [
    {"name" : "홍길동", "age" : 23, "phone":"010-123-1231"},
    {"name" : "임꺽정", "age" : 25, "phone":"010-123-1231"},
    {"name" : "장길산", "age" : 166, "phone":"010-123-1231"},
    {"name" : "두두둥", "age" : 17, "phone":"010-123-123"}
]

persons.forEach( (p) => {
    console.log(p.name, p.age, p.phone);
});

console.log("-------------------------------------------------")
// 나이가 30이상만 추출
persons.filter (obj => obj.age >= 30)
        .forEach (p => {
            console.log(p.name, p.age, p.phone);
        });

console.log("-------------------------------------------------")
// 이름에 길자가 들어가는 사람
persons.filter (obj => obj.name.includes("길"))
    .forEach (p => {
        console.log(p.name, p.age, p.phone);
    });

// 정렬 문자나, 숫자나 JSON 객체를 주면 객체와 객체를 비교할 수는 없다.
// 데이터 비교함수를 전달해야 한다. 매개변수가 두 개의 객체를 주고
persons.sort((a, b) => a.age - b.age);  // 0보다 큰 값 0보다 작거나
console.log( persons );

console.log("--------------------------이름 순으로 정렬 -----------------------")
persons.sort((a, b) => a.name.localeCompare(b.name));  // 0보다 큰 값 0보다 작거나
console.log( persons );


let scores = [
    {"name":"홍길동", "kor":90, "eng":80, "mat":80},
    {"name":"임꺽정", "kor":100, "eng":100, "mat":100},
    {"name":"장길산", "kor":70, "eng":80, "mat":70},
    {"name":"조승연", "kor":80, "eng":60, "mat":40},
    {"name":"김성훈", "kor":40, "eng":50, "mat":20},
    {"name":"임재범", "kor":90, "eng":80, "mat":70}
]

// 1. map 함수를 사용하여 총점(total) 필드와 평균(avg) 필드 추가
scores.map( (s) => {
    s.total = s.kor + s.eng + s.mat;
    s.avg = s.total / 3.0;
    return s;   // map 함수는 반드시 리턴을 해줘야 함.
});

// 2. 총점을 기준으로 내림차순 정렬후 출력
scores.sort( (s1, s2) => s2.total - s1.total)
    .forEach( (s) => {
        console.log (s.name, s.total, s.avg);
    })


// 3. 평균이 80 이상인 학생들의 명단을 출력
scores.filter( s=> s.avg >= 80)
        .forEach( (s) => console.log(s.name));