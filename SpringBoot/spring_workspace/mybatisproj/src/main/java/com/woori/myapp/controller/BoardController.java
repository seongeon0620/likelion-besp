package com.woori.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.woori.myapp.common.Pager;
import com.woori.myapp.entity.BoardDto;
import com.woori.myapp.repository.BoardDao;

import jakarta.annotation.Resource;

@Controller
public class BoardController {

	@Resource(name="boardDao")
	BoardDao dao;
	
	@GetMapping("/board/list/{pg}")
	public String board_list(Model model, BoardDto dto, @PathVariable("pg")int pg) {
		String page = Pager.makePage(10, 100, pg);	// 한 페이지당 표출될 데이터 개수, 전체 개수, 현재 페이지
		dto.setPg(pg);
		
		List<BoardDto> list = dao.getList(dto);
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getTitle());
//		}
		
		model.addAttribute("boardList", list);
		model.addAttribute("page", page);
		
		return "/board/board_list";
	}
	
	@GetMapping("/board/view/{id}")
	public String board_view(Model model, @PathVariable("id") int id) {
		BoardDto dto = new BoardDto();
		dto.setSeq(id);
		BoardDto resultDto = dao.getView(dto);
		
		model.addAttribute("boardDetail", resultDto);
		return "/board/board_view";
	}
	
	@GetMapping("/board/write")
	public String board_write() {
		return "/board/board_write";
	}
	
	@PostMapping("/board/save")
	public String board_save(BoardDto dto) {
		dao.insert(dto);
		return "redirect:/board/list";
	}
	

}
