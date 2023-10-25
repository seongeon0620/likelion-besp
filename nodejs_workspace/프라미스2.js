let limit = 1000;
let promise = new Promise( function(reject, resolve) {
    if (limit < 10)
    {
        reject("10보다 값이 작습니다.");
    }

    s = 0;
    for (i = 1 ; i <= limit ; i++)
        s += i;
    resolve(s);
})
.then( (res) => {
    console.log( res );
    console.log("end.......");  // 먼저 출력되므로 아무런 의미 없는 코드임. 맨 하단이 아닌 안에 넣어줘야함 
})
.catch( (error) => {
    console.log( error );
});
