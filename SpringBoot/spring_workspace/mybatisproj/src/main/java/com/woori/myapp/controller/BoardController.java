package com.woori.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.woori.myapp.entity.BoardDto;
import com.woori.myapp.repository.BoardDao;

import jakarta.annotation.Resource;

@Controller
public class BoardController {

	@Resource(name="boardDao")
	BoardDao dao;
	
	@GetMapping("/board/list")
	public String board_list(Model model, BoardDto dto) {
		List<BoardDto> list = dao.getList(dto);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTitle());
		}
		
		return "/board/board_list";
	}

}
