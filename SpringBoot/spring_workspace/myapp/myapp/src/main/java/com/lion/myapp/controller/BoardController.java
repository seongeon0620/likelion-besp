package com.lion.myapp.controller;

import com.lion.myapp.entity.BoardDto;
import com.lion.myapp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="board")
public class BoardController {

    @Autowired
    BoardService service;

    @GetMapping("/list")    // http://localhost:9000/board/list?page=0&size=5
    public List<BoardDto> getAllList(BoardDto dto, Pageable pageable) {
        return service.getList(dto, pageable);
    }
}
