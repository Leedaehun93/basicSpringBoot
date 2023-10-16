package com.example.mybatisexam.service.exam01;


import com.example.mybatisexam.dao.EmpDao;
import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Dept;
import com.example.mybatisexam.model.vo.Emp;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.mybatisexam.service.exam01
 * fileName : EmpService
 * author : L.DH
 * date : 2023-10-12
 * description : CRUD 서비스 클래스(업무 로직)
 * 1. 전체 조회 : like 기능
 * 2. 상세 조회
 * 3. 저장 함수
 * 4. 수정 함수
 * 5. 삭제 함수
 * 6. 다이나믹 SQL
 * 요약 :
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
 *  todo: 연습3) 부서 클래스를 참고하여 사원에 저장기능을 추가하세요
 *    empDao.java, emp.xml, EmpService, EmpController, add_emp.jsp
 *    사원 추가페이지 url : /emp/addition
 *                 jsp : exam01/emp/add_emp.jsp
 *    사원 db 저장 url : /emp/add
 *      redirect jsp : /exam01/emp
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
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */
@Slf4j
@Service
public class EmpService {
    @Autowired
    EmpDao empDao;

    /**
     * ename like 함수
     */
    public PageRes<Emp> findByEnameContaining(String ename, PageReq pageReq) {
//        TODO : 전체 조회 (like 됨)
        List<Emp> list = empDao.findByEnameContaining(ename, pageReq);

//        TODO : 페이징 처리 로직
//         1) 총 테이블 개수 :
        long totalCount = empDao.countByEname(ename);
//        TODO : 생성자 페이지 결과 객체(PageRes)
        PageRes pageRes = new PageRes(list,               // 검색 결과 배열
                pageReq.getPage(),  // 현재 페이지 번호
                totalCount,         // 총 테이블 건수
                pageReq.getSize()   // 1 페이지당 개수
        );

        return pageRes;
    }

    /**
     * 상세 조회
     */
    public Optional<Emp> findById(int eno) {
//  db 상세 조회 호출
        Optional<Emp> optionalEmp = empDao.findById(eno);

        return optionalEmp;
    }

    /**
     * 저장 함수 : DML( 트랜잭션(cud만 해당)을 동반 : 테이블에 값을 수정/삭제/넣는 행위 )
     * 수정 함수 : 기본키(dno) 없으면 insert, 기본키(dno) 있으면 update
     */
    public int save(Emp emp) {
        int queryResult = -1; // 저장된 건수를 위한 변수

        // 에러(예외)처리 함수
        try {
//          TODO : 기본키(eno) 없으면 insert
            if (emp.getEno() == null) {
                log.debug("-----------------------insert-----------------");
                log.debug("emp.getEno() : " + emp.getEno());
                queryResult = empDao.insert(emp);
            } else {
//          TODO : 기본키(eno) 있으면 update
                log.debug("update");
                log.debug("emp.getEno() : " + emp.getEno());
                queryResult = empDao.update(emp);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return queryResult;
    }

    /**
     * 삭제 함수 DML( 트랜잭션(cud만 해당)을 동반 : 테이블에 값을 수정/삭제/넣는 행위 )
     */
    public boolean removeById(int eno) {
        // 에러(예외)처리 함수
        try {
            if (empDao.existById(eno) > 0) {
                empDao.deleteById(eno);

                return true;
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return false;
    }

    /**
     * TODO : dynamic sql 조회
     */
    public PageRes<Emp> findByDynamicContaining(
            String ename,
            String job,
            Integer manager,
            PageReq pageReq
    ) {


//      TODO: dynamic 조회 (like 됨)
        List<Emp> list = empDao.findByDynamicContaining(
                                                         ename,
                                                         job,
                                                         manager,
                                                         pageReq
                                                         );

//        TODO : 페이징 처리 로직
//         1) 총 테이블 개수 :
        long totalCount = empDao.countByDynamic(ename, job, manager);
//        TODO : 생성자 페이지 결과 객체(PageRes)  => jsp 로 페이징 정보를 주기위해 코딩함
        PageRes pageRes = new PageRes(
                list,               // 검색 결과 배열
                pageReq.getPage(),  // 현재 페이지 번호
                totalCount,         // 총 테이블 건수
                pageReq.getSize()   // 1 페이지당 개수
        );

        return pageRes;
    }

}