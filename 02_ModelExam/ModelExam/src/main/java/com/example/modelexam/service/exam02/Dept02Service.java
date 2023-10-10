package com.example.modelexam.service.exam02;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam02
 * fileName : Dept02Service
 * author : L.DH
 * date : 2023-10-06
 * description :
 * 부서 업무 서비스 클래스, @Service, @Autowired, findAll()
 * 요약 :
 * TODO : @Service : 업무 로직 담당 클래스 위에 붙이는 어노테이션
 * => 스프링 서버 가동될 때 그 클래스 생성해 둠(싱글톤)
 * => 객체를 만들어서 함수를 쓸 때 : new 생성자함수()
 * => 스프링에서는 하지 않고 미리 만들어 둔 객체를 받아서 사용함
 * (참고 용어 IOC : 제어의 역전)
 * 기타 : @Repository, @Compinent 등
 *
 * @Autowired : 스프링에서 미리 만들어 둔 객체를 가져오기
 * 사용법 : 변수 위에 또는 생성자함수 위에 붙이는 가져올 수 있음
 * (참고 용어 DI : 의존성 주입)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-06         L.DH         최초 생성
 */
@Service
public class Dept02Service {

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
}