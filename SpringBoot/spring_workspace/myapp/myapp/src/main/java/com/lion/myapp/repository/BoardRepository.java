package com.lion.myapp.repository;

import com.lion.myapp.entity.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository<BoardDto(디비에서 가져올 객체타입), long(primary key 형태)
public interface BoardRepository extends JpaRepository<BoardDto, Long> {
    List<BoardDto> findByTitleOrderByIdDesc(String title);
}
