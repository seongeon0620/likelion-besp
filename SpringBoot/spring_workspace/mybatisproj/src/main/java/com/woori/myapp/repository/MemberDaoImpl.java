package com.woori.myapp.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.MemberDto;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public boolean idCheck(MemberDto dto) {
		int cnt = sm.selectOne("Member_idcheck", dto);
		// 아래는 굳이 else문이 필요하지 않음
		if (cnt == 0)
			return true;	// 사용 가능하다
		return false;
	}

	@Override
	public void insert(MemberDto dto) {
		sm.insert("Member_insert", dto);
	}

	@Override
	public MemberDto logon_proc(MemberDto dto) {
		// null 아니면 dto가 온다.
		// null : 아이디 존재안함. null이 아닐때는 다시 판단을 해야함
		return sm.selectOne("Member_logon", dto);
	}

	
}
