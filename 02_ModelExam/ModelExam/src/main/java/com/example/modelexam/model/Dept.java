package com.example.modelexam.model;

import lombok.*;

/**
 * packageName : com.example.modelexam.model
 * fileName : Dept
 * author : kangtaegyung
 * date : 2022/10/12
 * description : 부서 모델 클래스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/12         kangtaegyung          최초 생성
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Dept extends BaseTimeEntity {
    //    부서넘버
    private Integer dno;
    //    부서이름
    private String dname;
    //    부서위치
    private String loc;

    @Builder
    public Dept(Integer dno, String dname, String loc) {
        super();
        this.dno = dno;
        this.dname = dname;
        this.loc = loc;
    }
}
