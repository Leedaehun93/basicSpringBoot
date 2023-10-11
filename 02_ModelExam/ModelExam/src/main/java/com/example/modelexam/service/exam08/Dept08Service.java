package com.example.modelexam.service.exam08;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.service.exam08
 * fileName : Dept08Service
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 상세 조회(1건 조회)
 * 요약 : react 연동(vue 등) + null 방지 기능 추가
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         L.DH          최초 생성
 */
@Service
public class Dept08Service {
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
     * 수정 : null 방지 기능 추가
     * @param dno
     * @return
     */
    public Optional<Dept> findById(long dno) {
//       TODO : db 상세조회(1건조회) 함수 호출
//          id(기본키)로 조회
        Dept dept = deptDao.selectById(dno);
//      todo 추가 : null 방지 클래스 사용
        Optional<Dept> optionalDept = Optional.ofNullable(dept);
//      todo 추가 : return 수정
        return optionalDept;
    }

}