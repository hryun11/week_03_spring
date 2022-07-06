package com.hanghae.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// interface는 class에서 멤버변수가 없고 method만 있음.
// BoardRepository가 Jpa Repository(미리 작성된 여러가지 코드들(findAll, delete, findById, Save 등)를 갖다 쓸 것이다.
// Board 클래스의 Long인 것에 대해 갖다 씀.
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByCreatedAtDesc();
    // Board 리스트를 findAll(전부 가져와서) By OrderBy(순서대로 정렬해라) CreatedAt(생성날짜 순서) Desc(내림차순으로)

}
