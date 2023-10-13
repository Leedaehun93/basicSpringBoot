package com.example.mybatisexam.service.exam01;

import com.example.mybatisexam.dao.DeptDao;
import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.mybatisexam.service.exam01
 * fileName : DeptService
 * author : L.DH
 * date : 2023-10-12
 * description : CRUD 부서 서비스 클래스(업무 로직)
 * 1. 전체 조회 : like 기능
 * 2. 상세 조회
 * 3. 저장 함수
 * 4. 수정 함수
 * 5. 삭제 함수
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */
@Slf4j
@Service
public class DeptService {
    @Autowired
    DeptDao deptDao;    // db crud 함수들이 있는 클래스

    /**
     * 전체 조회 dname like 검색
     */
    public PageRes<Dept> findByDnameContaining(String dname,
                                               PageReq pageReq) {
//        TODO : 전체 조회 (like 됨)
        List<Dept> list = deptDao.findByDnameContaining(dname, pageReq);

//        TODO : 페이징 처리 로직
//         1) 총 테이블 개수 :
        long totalCount = deptDao.countByDname(dname);
//        TODO : 생성자 페이지 결과 객체(PageRes)
        PageRes pageRes = new PageRes(
                list,               // 검색 결과(부서) 배열
                pageReq.getPage(),  // 현재 페이지 번호
                totalCount,         // 총 테이블 건수
                pageReq.getSize()   // 1 페이지당 개수
        );

        return pageRes;
    }

    /**
     * 상세 조회
     */
    public Optional<Dept> findById(int dno) {
//  db 상세 조회 호출
        Optional<Dept> optionalDept = deptDao.findById(dno);

        return optionalDept;
    }

    /**
     * 저장 함수 : DML( 트랜잭션(cud만 해당)을 동반 : 테이블에 값을 수정/삭제/넣는 행위 )
     * 수정 함수 : 기본키(dno) 없으면 insert, 기본키(dno) 있으면 update
     */
    public int save(Dept dept) {
        int queryResult = -1; // 저장된 건수를 위한 변수

        // 에러(예외)처리 함수
        try {
//          TODO : 기본키(dno) 없으면 insert
            if (dept.getDno() == null) {
                queryResult = deptDao.insert(dept);
            } else {
//          TODO : 기본키(dno) 있으면 update
                queryResult = deptDao.update(dept);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return queryResult;
    }

    /**
     * 삭제 함수 DML( 트랜잭션(cud만 해당)을 동반 : 테이블에 값을 수정/삭제/넣는 행위 )
     */
    public boolean removeById(int dno) {
        // 에러(예외)처리 함수
        try {
            if (deptDao.existById(dno) > 0) {
                deptDao.deleteById(dno);

                return true;
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return false;
    }

} // end of class