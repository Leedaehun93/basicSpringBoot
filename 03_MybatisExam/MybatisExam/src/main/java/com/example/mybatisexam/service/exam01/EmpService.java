package com.example.mybatisexam.service.exam01;



import com.example.mybatisexam.dao.EmpDao;
import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.mybatisexam.service.exam01
 * fileName : EmpService
 * author : L.DH
 * date : 2023-10-12
 * description : 전체 조회 : like 기능
 * 요약 : 부서 서비스 클래스(업무 로직)
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
@Service
public class EmpService {
    @Autowired
    EmpDao empDao;

    /** ename like 함수 */
    public PageRes<Emp> findByEnameContaining(String ename,
                                              PageReq pageReq) {
//        TODO : 전체 조회 (like 됨)
        List<Emp> list = empDao.findByEnameContaining(ename, pageReq);

//        TODO : 페이징 처리 로직
//         1) 총 테이블 개수 :
        long totalCount = empDao.countByEname(ename);
//        TODO : 생성자 페이지 결과 객체(PageRes)
        PageRes pageRes = new PageRes(
                list,               // 검색 결과(부서) 배열
                pageReq.getPage(),  // 현재 페이지 번호
                totalCount,         // 총 테이블 건수
                pageReq.getSize()   // 1 페이지당 개수
        );

        return pageRes;
    }
}