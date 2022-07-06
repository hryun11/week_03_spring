package com.hanghae.week03.domain;

// RequestDto는 필요한 정보를 물고 다님

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Data
@Setter   // 값을 받을 때는 @requestbody에서 spring이 알아서 해줌. 그래서 setter 설정할 필요 없음.
@Getter     // private로 생성을 하면 가져오는데 문제가 생기므로 @Getter 해줘야함
@RequiredArgsConstructor

public class BoardRequestDto {
    private final Long id;
    private final String password;
    private final String title;
    private final String username;
    private final String contents;
}
