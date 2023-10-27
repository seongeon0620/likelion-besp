package com.woori.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String Index(Model model) {
		// model 객체가 컨트롤러부터 html로 값을 전달한다.
		model.addAttribute("myname", "홍길동");
		return "index";		// templates/index.html을 호출한다.
	}
	
	@GetMapping("/add")
	public String add(Model model, int x, int y) {
		int result = x + y;
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", result);
		
		return "add_result";
	}
	
	// 입력용 html 문서를 화면에 띄운다.
	@GetMapping("/input")
	public String input() {
		return "input";
	}
	
	// 변수를 int x, int y		class Data{int x, int y} Data d
	// 결과를 처리할 url 처리
	@GetMapping("/output")
	public String output(Model model, int x, int y, int z) {
		model.addAttribute("x", x);	// model 객체 = > controller를 통해 view로 값을 전달하는 객체
		model.addAttribute("y", y);
		model.addAttribute("z", z);
		return "output";
	}
}
