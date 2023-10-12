package com.example.mybatisexam.dao;


import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.vo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * packageName : com.example.mybatisexam.dao
 * fileName : EmpDao
 * author : L.DH
 * date : 2023-10-12
 * description :
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
@Mapper
public interface EmpDao {
    /** 전체 조회 : 부서명 like 기능 있음 */
    public List<Emp> findByEnameContaining(@Param("ename") String ename,
                                           PageReq pageReq
                                                   );
    /** 전체 테이블 개수 세기 함수 */
    long countByEname(String ename);
}
