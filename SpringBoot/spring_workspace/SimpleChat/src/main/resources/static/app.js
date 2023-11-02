//StompJS 라이브러리를 이용해 데이터를 주고 받는다. : 스프링에서 제공하는 라이브러리 
//JSON 형태로 데이터를 전달한다 
//브로커주소 전달자 프로토콜은 ws 또는 wss이다. 
//설정파일에 사용한 값으로 시작을 한다. 
//포트번호는 웹서버와 같은것을 사용한다
// stompClient : 데이터를 주고받을 객체 상수이므로 새로운 객체로 바꾸진 못하나 객체 안의 정보를 바꾸는것은 가능하다.
const stompClient = new StompJs.Client({
	// 설정파일의 registry.addEndpoint("/testwebsocket")
    brokerURL: 'ws://localhost:9000/testwebsocket'
});

//접속요청이 오면 웹소켓의 경우에 별도로 서버와 클라이언트 개념이 없다. 서로 주고 받을 수 있디 
stompClient.onConnect = (frame) => {
    setConnected(true);//연결을한다. 
    console.log('Connected: ' + frame); //연결요청받은 로그를 남긴다
    // registry.enableSimpleBroker("/topic")
    // 정보를 기다린다. /topic/greeting로 오면
    // greeting => Message 객체
    stompClient.subscribe('/topic/greeting', (greeting) => {
		console.log(greeting);
		// 이데이터가 문자열로 온다 => JSON.parse
        showGreeting(JSON.parse(greeting.body).content);
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.publish({
        destination: "/app/hello",
        body: JSON.stringify(
			{'name': $("#name").val(), 'msg':$("#msg").val()}
		)
    });
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $( "#connect" ).click(() => connect());
    $( "#disconnect" ).click(() => disconnect());
    $( "#send" ).click(() => sendName());
});