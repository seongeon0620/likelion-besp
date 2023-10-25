function add( x, y ) {
    return x + y;
}

// console.log( add(4, 5) );

// 1~n까지의 합계를 구해서 반환하는 함수
function sigma(limit = 100)  // 매개변수 기본값 - 매개변수에 값을 준다
{
    if ( limit < 10 )
        return;     // undefined 리턴
    
    s = 0;
    for(i = 1; i <= limit; i++)
    {
        s+=i;
    }
    return s;
}

console.log( sigma() );     // 0 (기본값 미지정 : 0, 지정 => 5050)
console.log( sigma(5) );    // undefined
console.log( sigma(10) );   // 55

function add2(x=1, y=2, z=3)
{
    console.log("x = ", x);
    console.log("y = ", y);
    console.log("z = ", z);

    return x+y+z;
}

// 자바스크립트는 오버로딩을 지원하지 않는다.
// 함수의 이름이 같은 것을 만들 수 없다. 대신에 매개변수 기본값을 통해 오버로딩과 같은 효과를 갖는다.
console.log("--------------------");
console.log( add2() );  // 6
console.log( add2(10) );    // 15
console.log( add2(10, 20) );    // 33
console.log( add2(10, 20, 30) );    // 60
console.log( add2(b=33) );  // 38

// 함수가 너무 많다. 항상 메모리를 차지하니까 메모리의 효율성이 떨어진다.
// 일회용함수를 만들어보자. 쓰고버리자. 이벤트 핸들러
// 함수 표현식 - 이름이 없는 함수를 만들어 쓴다

let funadd = function( x = 0, y = 0, z = 0) {
    return x+y+z;
}

console.log ( funadd(1, 2, 3));

// 화살표 함수 - 람다
// return 구문도 생략하고, {} 생략하고
let arrowadd = ( x = 0, y = 0, z = 0) => x+y+z;
console.log( arrowadd() );  // 0
console.log( arrowadd(1,2,3) ); // 6

let numbers = [1,2,3,4,5,6,7,8,9,10,11];

// 짝수 홀수를 분리하자 
// 1) old
let odd = [];   // 새로운 배열을 만든다.
let even = [];   // 새로운 배열을 만든다. 

for(i=0; i<numbers.length; i++)
{
    if (numbers[i] % 2 == 0)
        even.push(numbers[i]);
    else
        odd.push( numbers[i]);
}

console.log( odd );
console.log( even );

// 2) new
// 람다를 이용했을 때
function isEven(x) {
    if (x%2==0)
        return true;
    return false;
}
even = numbers.filter( isEven );
console.log( even );
// 한번쓰고 버릴거라 굳이 함수를 선언할필요 없음.

even = numbers.filter(x => x%2 == 0);
odd = numbers.filter(x => x%2 == 1);
console.log(odd);
console.log(even);
