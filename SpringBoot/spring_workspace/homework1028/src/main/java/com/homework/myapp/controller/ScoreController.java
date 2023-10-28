package com.homework.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.homework.myapp.dto.ScoreDto;
import com.homework.myapp.service.ScoreService;

@Controller
public class ScoreController {
	
	@Autowired
	ScoreService service;
	
	@GetMapping("/score/list")
	public String score_list(Model model) {
		model.addAttribute("sList", service.getList());
		return "score_list";
	}
	
	@GetMapping("/score/write")
	public String score_write() {
		return "score_write";
	}
	
	@PostMapping("/score/save")
	public String score_save(ScoreDto dto) {
		dto.setTotal(dto.getKor() + dto.getEng() + dto.getMat());
		dto.setAvg((dto.getKor() + dto.getEng() + dto.getMat()) / 3);
		
		service.insert(dto);
		return "redirect:/score/list";
	}
	
	@GetMapping("/score/view/{idx}")
	public String score_view(Model model, @PathVariable int idx) {
		model.addAttribute("detail", service.getView(idx));
		return "/score_view";
	}
}
