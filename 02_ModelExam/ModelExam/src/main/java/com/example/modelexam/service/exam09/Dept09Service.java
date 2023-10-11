package com.example.modelexam.service.exam09;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.service.exam09
 * fileName : Dept09Service
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 저장 함수
 * 요약 : react 연동(vue 등)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         L.DH          최초 생성
 */
@Service
public class Dept09Service {
    @Autowired
    DeptDao deptDao; // 가짜 DB에 접근하는 객체

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