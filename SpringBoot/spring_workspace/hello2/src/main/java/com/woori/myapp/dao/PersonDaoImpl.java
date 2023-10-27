package com.woori.myapp.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.woori.myapp.dto.PersonDto;

// Controller -> 직접 Dao 컨택 가능
// -> 테이블이 3개 이상 작업이 되어야할때
// -> 트랜잭션 처리를 하고자 할 때 트랜잭션 처리를 컨트롤러에서 하게 되면 컨트롤러가 하는 일이 너무 많아진다.
// -> 트랜잭션 처리 등 제반의 복잡한 일들은 서비스단에서.
// -> 컨트롤러 => 여러개의 서비스 => 각각의 서비스가 여러개의 Dao를 소유한다.
@Repository
public class PersonDaoImpl implements PersonDao {

	List<PersonDto> perList = new ArrayList<PersonDto>();
	public PersonDaoImpl () {
		perList.add(new PersonDto(1, "홍길동", "010-000-0001", "hong@naver.com"));
		perList.add(new PersonDto(2, "배숑숑", "010-000-0004", "bae@naver.com"));
		perList.add(new PersonDto(3, "임꺽정", "010-000-0002", "lim@naver.com"));
		perList.add(new PersonDto(4, "장길산", "010-000-0004", "jang@naver.com"));
		perList.add(new PersonDto(5, "가나다", "010-000-0001", "ganada@naver.com"));
	}
	
	@Override
	public List<PersonDto> getList() {
		// ******** 중요 ************
		return perList;
	}

	@Override
	public void insert(PersonDto dto) {
		this.perList.add(dto);
	}

	@Override
	public PersonDto getView(int id) {
		return perList.get(id - 1);
	}

}
