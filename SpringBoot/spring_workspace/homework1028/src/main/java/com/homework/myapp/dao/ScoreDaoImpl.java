package com.homework.myapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.homework.myapp.dto.ScoreDto;

@Repository
public class ScoreDaoImpl implements ScoreDao {

	List<ScoreDto> sList = new ArrayList<ScoreDto>();
	public ScoreDaoImpl () {
		sList.add(new ScoreDto(1, "홍길동", 70, 60, 50, 180, 60));
		sList.add(new ScoreDto(2, "배성언", 70, 40, 40, 150, 50));
		sList.add(new ScoreDto(3, "임기현", 80, 80, 50, 210, 70));
		sList.add(new ScoreDto(4, "임꺽정", 90, 95, 85, 270, 90));
	}
	
	@Override
	public List<ScoreDto> getList() {
		return sList;
	}

	@Override
	public void insert(ScoreDto dto) {
		this.sList.add(dto);
	}

	@Override
	public ScoreDto getView(int idx) {
		return sList.get(idx - 1);
	}

}
