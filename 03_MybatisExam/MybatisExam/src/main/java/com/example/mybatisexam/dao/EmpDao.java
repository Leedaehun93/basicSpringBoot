package com.example.mybatisexam.dao;


import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.vo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.mybatisexam.dao
 * fileName : EmpDao
 * author : L.DH
 * date : 2023-10-12
 * description : CRUD Db 접속 함수들이(CRUD) 있는 클래스(mybatis mapper(=dao) 클래스)
 * 1. 전체 조회 : like 기능
 * 2. 상세 조회
 * 3. 저장 함수
 * 4. 수정 함수
 * 5. 삭제 함수
 * 6. 다이나믹 SQL
 * 요약 : 사원 Dao (Myabatis mapper : @Mapper 사용)
 * todo: 연습 1)부서클래스를 참고하여
 *     Emp 클래스 ( schema.sql 참고 )
 *     EmpDao 클래스 findByEnameContaining()
 *     emp.xml 클래스
 *     EmpService 클래스를 만들고 findByEnameContaining() 함수를 정의한다.
 *     EmpController 클래스를 만들어서 getEmpAll() 함수를 정의하고,
 *   샘플데이터를 뷰로(emp_all.html) 전송해 보세요.
 * <p>
 * todo: 연습 2) 부서 클래스를 참고해서 사원에 상세조회기능을 추가하세요.
 *         empDao, emp.xml, EmpService, EmpController
 *         (단, xml 에서 공통 sql 문을 이용하세요)
 *    url : /emp/{eno}
 *    jsp : exam01/emp/emp_id.jsp
 *    url test :   URL 테스트 : http://localhost:8000/exam01/emp/7788
 * <p>
 * todo: 연습 4) 부서 클래스를 참고하여 사원에 수정기능을 추가하세요
 *   empDao, emp.xml, EmpService, EmpController, update_emp.jsp
 *   수정 페이지 url :  /emp/edition/{eno}
 *             jsp : exam01/emp/update_emp.jsp
 *   db 수정 url    : /emp/edit/{eno}
 *     redirect jsp: /exam01/emp
 * <p>
 * todo: 연습 5) 부서 클래스를 참고하여 사원 삭제기능을 추가하세요
 *   empDao, emp.xml, EmpService, EmpController, update_emp.jsp 수정
 *            url : /emp/delete/{eno}
 *   redirect jsp : /exam01/emp
 * <p>
 * todo: 연습 4) 부서 클래스를 참고하여 사원에 다이나믹 조회 기능을 추가하세요
 *    sql문 2개 : 1) 다이나믹 조회 2) 다이나믹 카운트 조회
 *   empDao, emp.xml, empService, empController
 *   url : /emp/dynamic
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */
@Mapper
public interface EmpDao {
    /**
     * 전체 조회 : 부서명 like 기능 있음
     */
    public List<Emp> findByEnameContaining(@Param("ename") String ename,
                                           PageReq pageReq
    );

    /**
     * 전체 테이블 개수 세기 함수
     */
    long countByEname(String ename);

    /**
     * 상세 조회(1건조회)
     */
    Optional<Emp> findById(int eno);

    /**
     * 저장 함수
     */
    int insert(Emp emp);

    /**
     * 수정 함수
     */
    int update(Emp emp);

    /**
     * 삭제 함수
     */
    int deleteById(int eno);

    /**
     * 기본키(eno) 가 있는지 확인하는 조회 함수
     * eno 값이 있는지 확인하는 함수
     */
    long existById(int eno);

    /**
     * TODO : Dynamic SQL 조회
     */
    public List<Emp> findByDynamicContaining(
            @Param("ename") String ename,
            @Param("job") String job,
            @Param("manager") Integer manager,
            PageReq pageReq);

    /**
     * TODO : Dynamic SQL 작성 전체 카운트 조회
     */
    long countByDynamic(
            String ename,
            @Param("job") String job,
            @Param("manager") Integer manager
            );

} // end of interface
