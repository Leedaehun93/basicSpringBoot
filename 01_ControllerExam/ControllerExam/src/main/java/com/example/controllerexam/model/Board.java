package com.example.controllerexam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.controllerexam.model
 * fileName : Board
 * author : L.DH
 * date : 2023-10-06
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-06         L.DH         최초 생성
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Board {
    long no;            // 넘버
    String title;      // 제목
    String content;    // 내용
    String count;      // 조회수
}