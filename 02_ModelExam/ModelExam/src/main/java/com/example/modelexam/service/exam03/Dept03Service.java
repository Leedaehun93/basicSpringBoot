package com.example.modelexam.service.exam03;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam03
 * fileName : Dept03Service
 * author : L.DH
 * date : 2023-10-06
 * description : 서비스_부서 정보 저장 함수
 * 요약 :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-06         L.DH         최초 생성
 */
@Service
public class Dept03Service {

    @Autowired
    DeptDao deptDao; // 가짜 DB에 접근하는 객체

    /**
     * 전체 조회 함수 : selectAll()(DAO 객체 함수) 호출
     * @return
     */
    public List<Dept> findAll() {
//      TODO: deptDao.selectAll() : db 조회 함수 호출
        List<Dept> list = deptDao.selectAll();

        return list;
    }

    /**
     * id(기본키)로 조회 : 상세조회(1건조회)
     * @param dno
     * @return
     */
    public Dept findByid(long dno) {
//  TODO : db 상세조회(1건조회) 함수 호출
//  TODO : id(기본키)로 조회
        Dept dept = deptDao.selectById(dno);

        return dept;
    }

    /**
     * TODO 부서 정보 저장 함수
     * @param dept
     * @return
     */
    public List<Dept> save(Dept dept) {
        List<Dept> list = deptDao.insert(dept);

        return list;
    }
}