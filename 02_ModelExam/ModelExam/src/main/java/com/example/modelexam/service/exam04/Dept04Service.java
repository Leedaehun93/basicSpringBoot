package com.example.modelexam.service.exam04;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam04
 * fileName : Dept04Service
 * author : L.DH
 * date : 2023-10-06
 * description : 서비스_추가 및 저장
 * 요약 : 객체의 전체 조회 함수 호출 add 버튼 및 데이터 추가해보기
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-06         L.DH         최초 생성
 */
@Service
public class Dept04Service {

    @Autowired
    DeptDao deptDao; // 가짜 DB에 접근하는 객체

    /**
     * 전체 조회 함수 : selectAll()(DAO 객체 함수) 호출
     *
     * @return
     */
    public List<Dept> findAll() {
//      TODO: deptDao.selectAll() : db 조회 함수 호출
        List<Dept> list = deptDao.selectAll();

        return list;
    }

    /**
     * id(기본키)로 조회 : 상세조회(1건조회)
     *
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
     *
     * @param dept
     * @return
     */
    public List<Dept> save(Dept dept) {

        /**
         * 기존부서번호를 찾고 추가 부서번호 생성하여 저장하기
         */
        List<Dept> list = null;
//      TODO : insert 시 dno 자동 생성
//      TODO : 기존 부서번호 max 찾아서 + 10
        if (dept.getDno() == null) {
//          TODO : 전체 조회해서 현재 배열의 크기 가져오기
            int count = deptDao.selectAll().size();
//          TODO : 새로운 부서번호 생성
            int newDno = (count + 1) * 10;
//          TODO : 새로운 부서번호 저장 : dept
            dept.setDno(newDno);
//          TODO : db 저장
            list = deptDao.insert(dept);
        }

        return list;
    }
}