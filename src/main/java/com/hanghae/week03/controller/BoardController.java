package com.hanghae.week03.controller;

import com.hanghae.week03.domain.Board;
import com.hanghae.week03.domain.BoardRepository;
import com.hanghae.week03.domain.BoardRequestDto;
import com.hanghae.week03.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;  // 필수적인 것들이라 private final
    private final BoardService boardService;


    // 게시글 작성
    @PostMapping("/api/boards")
    public Board writeBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }


    // 전체 게시글 리스트 가져오기
    @GetMapping("/api/boards")
    public List<Board> getAllBoards() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }


    // 개별 게시글 조회
    @GetMapping("/api/boards/{id}")
    public Optional<Board> readBoard(@PathVariable Long id) {
        return boardRepository.findById(id);

//        Optional<Board> board = boardRepository.findById(id);
//
//        return board.get();
    }


    // 게시글 삭제
    @DeleteMapping("/api/boards/{id}")
    //@PathVariable은 경로에 있는 id를 변수로 받기 위해
    public Long deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (!board.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        boardRepository.deleteById(id);

        return id;
    }


    // 게시글 수정
    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.update(id, requestDto);
        return id;
    }


}
