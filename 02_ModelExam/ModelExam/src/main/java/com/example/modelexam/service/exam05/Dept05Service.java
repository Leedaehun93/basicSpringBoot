package com.example.modelexam.service.exam05;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam05
 * fileName : Dept05Service
 * author : L.DH
 * date : 2023-10-11
 * description : edition에서 업데이트 버튼 및 url 추가해보기
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         L.DH          최초 생성
 */
@Service
public class Dept05Service {
    //    todo : db 접근 함수들이 있는 객체 : deptEao
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
    public Dept findById(long dno) {
//       todo: db 상세조회(1건조회) 함수 호출
//          id(기본키)로 조회
        Dept dept = deptDao.selectById(dno);

        return dept;
    }

    /**
     * 부서 정보 저장 함수
     *
     * @param dept
     * @return
     */
    public List<Dept> save(Dept dept) {

        List<Dept> list = null;
//      todo: insert 시 dno 자동 생성
//        기존 부서번호 max 찾아서 + 10
        if (dept.getDno() == null) {
//            todo: 전체조회해서 현재 배열의 크기 가져오기
            int count = deptDao.selectAll().size();
//            todo: 새로운 부서번호 생성
            int newDno = (count + 1) * 10;
//            todo: 새로운 부서번호 저장 : dept
            dept.setDno(newDno);
//            todo: db 저장
            list = deptDao.insert(dept);
        } else {
//           todo: db 수정
            list = deptDao.update(dept);
        }

        return list;
    }
}
