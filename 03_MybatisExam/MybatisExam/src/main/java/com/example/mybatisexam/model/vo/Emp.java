package com.example.mybatisexam.model.vo;

import com.example.mybatisexam.model.common.BaseTimeEntity;
import lombok.*;

/**
 * packageName : com.example.mybatisexam.model.vo
 * fileName : Emp
 * author : L.DH
 * date : 2023-10-12
 * description : 부서 클래스 == 부서 테이블 유사
 * 요약 :
 * todo: 연습 1)부서클래스를 참고하여
 *     Emp 클래스 ( schema.sql 참고 )
 *     EmpDao 클래스 findByEnameContaining()
 *     emp.xml 클래스
 *     EmpService 클래스를 만들고 findByEnameContaining() 함수를 정의한다.
 *     EmpController 클래스를 만들어서 getEmpAll() 함수를 정의하고,
 *   샘플데이터를 뷰로(emp_all.html) 전송해 보세요.
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
    private Integer eno;
    private String ename;
    private String job;
    private String manager;
    private String hiredate;
    private Integer salary;
    private Integer commission;
    private Integer dno;
}
