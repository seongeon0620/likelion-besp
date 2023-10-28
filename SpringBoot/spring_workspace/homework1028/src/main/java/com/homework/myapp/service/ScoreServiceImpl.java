package com.homework.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.myapp.dao.ScoreDao;
import com.homework.myapp.dto.ScoreDto;

@Service
public class ScoreServiceImpl implements ScoreService{

	@Autowired
	ScoreDao dao;
	
	@Override
	public List<ScoreDto> getList() {
		return dao.getList();
	}

	@Override
	public void insert(ScoreDto dto) {
		dao.insert(dto);
	}

	@Override
	public ScoreDto getView(int idx) {
		return dao.getView(idx);
	}

}
