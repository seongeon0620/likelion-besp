package com.homework.myapp.dao;

import java.util.List;

import com.homework.myapp.dto.ScoreDto;

public interface ScoreDao {
	List<ScoreDto> getList();
	void insert(ScoreDto dto);
	ScoreDto getView(int idx);
}
