package com.hanghae.week03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Board extends Timestamped {

    @Id // id 값, Primary Key로 사용
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령
    private Long id;
    @Column(nullable = false)
    private String password;    // 비밀번호

    @Column(nullable = false)    // 컬럼 값. 반드시 값이 존재해야 함을 나타냄.
    private String title;   // 제목

    @Column(nullable = false)
    private String username;    // 작성자명

    @Column(nullable = false)
    private String contents;    // 작성 내용

//    public Board(String title, String username, String contents, String password, Long id) {
//        this.id = id;
//        this.title = title;
//        this.username = username;
//        this.contents = contents;
//        this.password = password;
//    }

    public Board(BoardRequestDto requestDto) {
        this.id = requestDto.getId();
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }


    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

//    public void read(BoardRequestDto requestDto) {
//        this.id = requestDto.getId();
//        this.title = requestDto.getTitle();
//        this.username = requestDto.getUsername();
//        this.contents = requestDto.getContents();
//    }

}
