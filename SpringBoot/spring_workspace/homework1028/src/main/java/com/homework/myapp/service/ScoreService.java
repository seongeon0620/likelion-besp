package com.homework.myapp.service;

import java.util.List;

import com.homework.myapp.dto.ScoreDto;

public interface ScoreService {
	List<ScoreDto> getList();
	void insert(ScoreDto dto);
	ScoreDto getView(int idx);
}
