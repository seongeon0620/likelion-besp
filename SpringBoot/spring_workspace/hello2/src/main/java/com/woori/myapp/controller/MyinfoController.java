package com.woori.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyinfoController {
	
	@GetMapping("/myname_input")
	public String myname_input() {
		return "myname_input";
	}
	
	@GetMapping("/myname_output")
	public String myname_output(Model model, String name, String phone) {
		model.addAttribute("name", name);
		model.addAttribute("phone", phone);
		return "myname_output";
	}
}
