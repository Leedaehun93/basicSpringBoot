package com.example.mybatisexam.model.vo;

import com.example.mybatisexam.model.common.BaseTimeEntity;
import lombok.*;

/**
 * packageName : com.example.mybatisexam.model.vo
 * fileName : Emp
 * author : L.DH
 * date : 2023-10-12
 * description : CRUD 부서 클래스 == 부서 테이블 유사
 * 1. 전체 조회 : like 기능
 * 2. 상세 조회
 * 3.
 * 요약 :
 * todo: 연습 1)부서클래스를 참고하여
 *     Emp 클래스 ( schema.sql 참고 )
 *     EmpDao 클래스 findByEnameContaining()
 *     emp.xml 클래스
 *     EmpService 클래스를 만들고 findByEnameContaining() 함수를 정의한다.
 *     EmpController 클래스를 만들어서 getEmpAll() 함수를 정의하고,
 *   샘플데이터를 뷰로(emp_all.html) 전송해 보세요.
 *
 * todo: 연습 2) 부서 클래스를 참고해서 사원에 상세조회기능을 추가하세요.
 *         empDao, emp.xml, EmpService, EmpController
 *         (단, xml 에서 공통 sql 문을 이용하세요)
 *    url : /emp/{eno}
 *    jsp : exam01/emp/emp_id.jsp
 *    url test :   URL 테스트 : http://localhost:8000/exam01/emp/7788
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
