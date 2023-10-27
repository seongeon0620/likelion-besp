package com.woori.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.dto.PersonDto;
import com.woori.myapp.service.PersonService;

@Controller
public class PersonController {
	
	// DI 상황
	@Autowired
	PersonService service;
	
	@GetMapping("/person/list")
	public String person_list(Model model) {
		List<HashMap<String, Object>> sList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "홍길동");
		map.put("age", 23);
		sList.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "임꺽정");
		map.put("age", 27);
		
		sList.add(map);
		
		model.addAttribute("title", "머스티치 for문 연습");
		model.addAttribute("sList", sList);
		
		// 함수의 반환이 반드시 String 이어야 한다. @Controller일때
		return "person_list";
	}
	
	@GetMapping("/person/list2")
	public String person_list2(Model model) {
		// 서비스를 통해서 데이터를 가져와서 모델에 저장해서 보낸다.
		model.addAttribute("personList", service.getList());
		return "person_list2";
	}
	
	@GetMapping("/person/write")
	public String person_write() {
		return "person_write";
	}
	
	@PostMapping("/person/save")
	public String person_save(PersonDto dto) {
		service.insert(dto);
		// redirect => html 페이지에 데이터를 입력 => save 에서 저장
		// person_list() 직접 호출 가능하다. 근데 /person/list url
		// 무언가 처리할때에는 redirect 사용.
		// redirect:/person/list => /person/list 
		// ajax => json 데이터만 보내고 말아야 한다. 받는 쪽에서 자바스크립트를 사용해서 전달한다.

		// forward : 클라이언트에서 온 정보를 그대로 갖고 페이지로 이동
		// redirect : 클라이언트에서 온 정보를 지우고 페이지로 이동
		return "redirect:/person/list2";
	}
	
	// person/view/1
	@GetMapping("/person/view/{id}")
	public String getView(Model model, @PathVariable("id") int id) {
		model.addAttribute("view", service.getView(id));
		return "person_view";
	}
	
	@PostMapping("/person/save2")
	@ResponseBody
	// 기본적으로 $.ajax가 데이터를 보낼때는 json이 아닌 text로 전송한다. 
	// 자바스크립트의 fetch 함수나 Axios는 기본이 json으로 받기 때문에 파라미터 앞에 @RequestBody를 써줘야 한다.
	public HashMap<String, Object> person_save2(PersonDto dto) {
		service.insert(dto);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", "success");
		resultMap.put("name", dto.getName());
		resultMap.put("phone", dto.getPhone());
		resultMap.put("email", dto.getEmail());
		
		return resultMap;
	}
	
}
