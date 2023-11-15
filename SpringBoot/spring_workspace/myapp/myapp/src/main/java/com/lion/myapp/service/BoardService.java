package com.lion.myapp.service;

import com.lion.myapp.entity.BoardDto;
import com.lion.myapp.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional // 자동 트랜잭션 처리 => ex) 콘서트 공연
public class BoardService {
    @Autowired
    BoardRepository boardRepo;

    public List<BoardDto> getList(BoardDto dto, Pageable pageable) {
        return boardRepo.findAll(pageable).getContent();
    }

    public int getTotalCount() {
        return (int)boardRepo.count();
    }

    // insert, update, delete 등에는 @Transactional
    @Transactional
    public void insert(BoardDto dto) {
        // dto 객체에 id 필드에 값이 있으면 update 쿼리가 작동된다.
        boardRepo.save(dto);
    }

    @Transactional
    public void update(BoardDto dto) {
        // dto객체에 id 필드에 있는 값과 일치하면 update 쿼리 작동
        boardRepo.delete(dto);
    }

    @Transactional
    public void delete(BoardDto dto) {
        boardRepo.delete(dto);
    }

    public Optional<BoardDto> getView(Long id) {
        return boardRepo.findById(id);
    }

    // Optional => lambda : 객체가 null 값을 가질때 if문으로 객체가 null인 경우와 아닌경우 나눠 작업을 한다.
}
