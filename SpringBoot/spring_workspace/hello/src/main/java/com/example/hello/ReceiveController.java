package com.example.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveController {	
	// add?x=5&y=7
	@GetMapping("/add")
	public String add(int x, int y) {
		int result = x + y;
		return String.format("%d + %d = %d", x, y, result);
	}
	
	// add2/5/7
	@GetMapping("/add2/{x}/{y}")
	public String add2(@PathVariable("x")int x, @PathVariable("x")int y) {
		int result = x + y;
		return String.format("%d + %d = %d", x, y, result);
	}
	
	// 문제1. gugu/4
	// 문제2. gugu2?dan=4
	@GetMapping("/gugu/{dan}")
	public String gugu(@PathVariable("dan") int dan) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 1; i <=9 ; i++) {
			buffer.append(String.format("%d X %d = %d<br />", dan, i, dan*i));
		}
		return buffer.toString();
	}
	
	@GetMapping("/gugu2")
	public String gugu2(int dan) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 1; i <=9 ; i++) {
			buffer.append(String.format("%d X %d = %d<br />", dan, i, dan*i));
		}
		return buffer.toString();
	}
	
	/*
	 * 멀티스레드 - 프로세스를 작은 조각으로 만든다
	 * 자바의 경우에는 Thread 라는 클래스를 상속받거나 Runnable 인터페이스를 구현하는 경우가 있고, 아래의 경우에 사용한다
	 * 1) 네트워크를 사용
	 * 2) 용량이 엄청 큰 파일을 읽음
	 * 3) 디비데이터 처리
	 * 동일한 자원(변수)에 접근하는 문제. 동시성문제, 동기화문제
	 * 스레드 안정성. 동기화를 지원해야한다. 
	 * 동기지원 안한다 - 스레드 안정성이 떨어진다.
	 * 그래서 이러한 클래스 사용을 피하자. 
	 * StringBuilder => StringBuffer, HashTable => HashMap
	 * */
	
	/*
	 * x-www-form-urlencoded : form 태그에 post 방식으로 보낼 때
	 * form-data : form 태그에 post, enctype="multipart/form-data"
	 * 					파일태그가 작동을 하며, spring에서는 request객체가 아닌, 별도의 multipartrequest 객체가 처리
	 * raw : json형식
	 * 
	 * */
	
	@PostMapping("/add_post")
	public String add_post(int x, int y) {
		return String.format("%d + %d = %d", x, y, x+y);
	}
	
	// post 방식은 html 페이지를 만들어 post 전송을 하거나 별도의 툴 도움을 받아야 한다.
	// curl: 윈도우, 리눅스 둘 다 가능하다.
	// postman, insomnia
	
	@PostMapping("/add_json")	// 자바스크립트 fetch, axios 라이브러리
	public String add_json(@RequestBody HashMap<String, String>map) {
		int x = Integer.parseInt(map.get("x"));
		int y = Integer.parseInt(map.get("y"));
		return String.format("%d + %d = %d", x, y, x+y);
	}
	
	@PostMapping("/score_json")
	public HashMap<String, Object> score_json(@RequestBody HashMap<String, String>map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int kor = Integer.parseInt(map.get("kor"));
		int eng = Integer.parseInt(map.get("eng"));
		int mat = Integer.parseInt(map.get("mat"));
		
		resultMap.put("name", map.get("name"));
		resultMap.put("kor", kor);
		resultMap.put("eng", eng);
		resultMap.put("mat", mat);
		
		int total = kor + eng + mat;
		
		resultMap.put("total", total);
		resultMap.put("avg", total / 3);
		return resultMap;
	}
	
	@PostMapping("/trade_json")
	public HashMap<String, Object> trade_json(@RequestBody HashMap<String, Object> map) {
		map.put("trade_id", map.get("trade_id"));
		
		@SuppressWarnings("unchecked")
		List<HashMap<String, Object>> list = (List<HashMap<String, Object>>)map.get("trade");
		int total = 0;
		for (int i = 0; i <list.size() ; i++) {
			total += Integer.parseInt(list.get(i).get("payment").toString());
		}
		
		map.put("trade", list);
		map.put("sum", total);
		
		return map;
	}
}
