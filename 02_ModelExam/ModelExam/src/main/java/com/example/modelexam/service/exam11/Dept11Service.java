package com.example.modelexam.service.exam11;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.service.exam11
 * fileName : Dept11Service
 * author : L.DH
 * date : 2023-11-11
 * description : @RestController 삭제 기능
 * 요약 : react 연동(vue 등)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         L.DH          최초 생성
 */
@Service
public class Dept11Service {

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
     * 부서번호로 삭제하는 함수
     *
     * @param dno
     * @return
     */
    public boolean removeById(int dno) {
//      삭제 함수 호출 : 리턴값 : (삭제된 건수)
        int iCount = deptDao.deleteById(dno);

        return (iCount > 0) ? true : false;
    }
}