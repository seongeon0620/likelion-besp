package com.example.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MustacheController {
	//View 엔진과 연동하려면
	
	// 함수들이 String으로 리턴 => view 엔진에 있는 파일과 연동이 된다.
	@GetMapping("/mustache1")
	public String mustache1() {
		return "mustache1";	// templates : mustache1.
		// 설정파일에서(application properties) 나는 머스티치 엔진을 사용할거고, 파일확장자 html => mustache로 받아들이겠다는 설정을 해줘야 함
	}

}
