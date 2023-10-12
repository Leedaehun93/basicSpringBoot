package com.example.mybatisexam.service.exam01;

import com.example.mybatisexam.dao.DeptDao;
import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.mybatisexam.service.exam01
 * fileName : DeptService
 * author : L.DH
 * date : 2023-10-12
 * description : 전체 조회 : like 기능
 * 요약 : 부서 서비스 클래스(업무 로직)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */
@Service
public class DeptService {
    @Autowired
    DeptDao deptDao;    // db crud 함수들이 있는 클래스

    /** dname like 함수 */
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
}






