package com.woori.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woori.myapp.dao.PersonDao;
import com.woori.myapp.dto.PersonDto;

// @Controller, @RestController, @Service, @Repository를 찾아
// 쓰여있는 클래스만 스스로 객체를 만들어서 주입시켜 준다.
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired		// 타입을 보고 적당한 객체를 주입한다. DI
	PersonDao dao;

	@Override
	public List<PersonDto> getList() {
		// *** 중요
		return dao.getList();
	}

	@Override
	public void insert(PersonDto dto) {
		dao.insert(dto);
	}

	@Override
	public PersonDto getView(int id) {
		return dao.getView(id);
	}
}
