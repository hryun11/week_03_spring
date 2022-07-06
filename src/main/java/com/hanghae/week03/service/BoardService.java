package com.hanghae.week03.service;

import com.hanghae.week03.domain.Board;
import com.hanghae.week03.domain.BoardRepository;
import com.hanghae.week03.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor    // final로 선언했으면 넣어줌. 생성자를 알림.
@Service
public class BoardService {
    private final BoardRepository boardRepository;  // final로 필수를 알림.

    // 게시글 수정
    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {

        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (!board.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        board.update(requestDto);

        return board.getId();

    }




}
