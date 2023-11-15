package com.lion.myapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
// 매개변수가 없는 생성자를 protected 접근자로 만들어라 => 직접 객체생성 하지마라
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="TB_BOARD")
// dbms마다 다르다 => id자동증가 방식이 oracle과 mysql이 다르다.
@SequenceGenerator(
        name="SEQ_BOARD_GENERATOR",
        sequenceName = "SEQ_TB_BOARD",
        initialValue = 1,
        allocationSize = 1
)   // oracle의 시퀀스를 사용하기 위한 코드이다.

public class BoardDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD")
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String writer;

    @Column(nullable = true, length = 100)
    private String contents;

    private LocalDateTime createDate = LocalDateTime.now();

    @Builder

    public BoardDto(String title, String contents, String writer) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
}
