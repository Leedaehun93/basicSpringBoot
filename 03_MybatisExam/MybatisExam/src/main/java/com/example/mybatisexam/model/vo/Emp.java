package com.example.mybatisexam.model.vo;

import com.example.mybatisexam.model.common.BaseTimeEntity;
import lombok.*;

/**
 * packageName : com.example.mybatisexam.model.vo
 * fileName : Emp
 * author : L.DH
 * date : 2023-10-12
 * description : CRUD 부서 클래스 == 부서 테이블 유사
 * 요약 :
 * TODO : vo(Value Object) : 테이블과 동일하게 만듬
 * TODO : dto(Data Transfer Object) : 테이블 + 가공컬럼(속성)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Emp extends BaseTimeEntity {
    private Integer eno;        // 사원번호
    private String ename;       // 사원명
    private String job;         // 직위
    private Integer manager;    // 매니저
    private String hiredate;    // 입사일
    private Integer salary;     // 급여
    private Integer commission; // 상여금
    private Integer dno;        // 부서번호
}
