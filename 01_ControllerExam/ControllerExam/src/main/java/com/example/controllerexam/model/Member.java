package com.example.controllerexam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.controllerexam.model
 * fileName : Member
 * author : L.DH
 * date : 2023-10-05
 * description : 회원 클래스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-05         L.DH         최초 생성
 */
// TODO : Lombok 라이브러리 : 유용한 @ 모은 라이브러리
//  @Setter : setter 함수를 만들어주는 어노테이션
//  @Getter : getter 함수를 만들어주는 어노테이션
//  @ToString : toString 재정의 함수 자동으로 만들어주는 어노테이션
//  @AllArgsConstructor : 모든 속성을 가진 생성자 자동 정의
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Member {
    //  TODO : 속성, 생성자, 함수(getter/setter)
    String id;      // 회원 id
    String name;    // 회원명
}
