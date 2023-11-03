package com.woori.myapp.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.service.MemberService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	MemberService service;
	
	@GetMapping("/member/write")
	public String member_write() {
		return "/member/member_register";
	}
	
	/*
	 * 1. iframe - html5 없어짐
	 * 2. popup창- 안씀. 안드로이드나 아이폰에서 웹사이트 접근시 popup창 문제가 발생
	 * 3. ajax - 현재 유일한 방법
	 */
	@GetMapping("/member/idcheck")
	@ResponseBody
	public HashMap<String, Object> member_idcheck(MemberDto dto) {
		// id 사용가능 여부를 보내야 한다.
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (service.idCheck(dto))
			map.put("result", "success");
		else
			map.put("result", "fail");
		
		return map;
	}
	
	// ajax로 등록을 함 => 데이터 타입이 String, List, HashMap으로 return. redirect 못함
	@PostMapping("/member/save")
	@ResponseBody
	public HashMap<String, Object> member_save(MemberDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 원래는 받아서 데이터 양식에 맞는지 에러체크 한다.
		// 패스워드 암호화등의 작업을 해야 한다.
		service.insert(dto);
		
		map.put("result", "success");
		return map;
	}
	
	@GetMapping("/member/logon")
	public String member_login() {
		return "member/member_logon";
	}
	
	@PostMapping("/member/logonproc")
	@ResponseBody
	public HashMap<String, Object> member_loginproc(MemberDto dto, HttpServletRequest request) {
		HttpSession session = request.getSession();		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 1. 로그인 성공 / 2. 아이디 존재안함 / 3. 패스워드 일치안함.
		
		MemberDto resultDto = service.logon_proc(dto);
		int result = getResult(resultDto, dto);
		
		map.put("result", result);
		if (result == 1) {
			map.put("msg", "로그온 성공");
			session.setAttribute("user_id", resultDto.getUser_id());
			session.setAttribute("user_name", resultDto.getUser_name());
			session.setAttribute("phone", resultDto.getPhone());
			session.setAttribute("email", resultDto.getEmail());
		}
		else if (result == 2)
			map.put("msg", "아이디 존재 안함");
		else if (result == 3)
			map.put("msg", "패스워드 불일치");
		
		return map;
	}
	
	int getResult(MemberDto resultDto, MemberDto dto) {
		if (resultDto == null) 
			return 2;
		
		if (!resultDto.getPassword().equals(dto.getPassword()))
			return 3;
		
		return 1;
		
	}
}
