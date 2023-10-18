package com.example.jpaexam.service;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service
 * fileName : DeptService
 * author : L.DH
 * date : 2023-10-16
 * description : 부서 업무 서비스
 * 요약 : JPA를 이용한 기본 CRUD
 * 1. Repository 전체 조회
 * 2. Repository 상세 조회
 * 3. Repository 저장 함수
 * 4. Repository 수정 함수
 * 5. Repository 삭제 함수
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-16         L.DH         최초 생성
 */
@Service
public class DeptService {
    @Autowired
    DeptRepository deptRepository;  // com.example.jpaexam.repository 에 DeptRepository 인터페이스 DI 객체 가져오기

    /**
     * 전체 조회
     */
    public List<Dept> findAll() {
        List<Dept> list = deptRepository.findAll(); // db 전체 조회 함수 호출

        return list;
    }

    /**
     * 상세 조회
     */
    public Optional<Dept> findById(int dno) {
        Optional<Dept> optionalDept = deptRepository.findById(dno);

        return optionalDept;
    }

    /**
     * 저장 함수
     */
    public Dept save(Dept dept) {
//        TODO : jap 저장함수 호출( 기본키 없으면 insert, 있으면 update )
        Dept dept2 = deptRepository.save(dept);

        return dept2; // 저장된 부서객체
    }

    /**
     * 삭제함수
     */
    public boolean removeById(int dno) {

//      existsById : jpa 함수 - 리턴값: 있으면 true, 없으면 false
        if (deptRepository.existsById(dno)) {
            deptRepository.deleteById(dno); // DB 삭제(dno)
            return true;
        }
        return false;
    }

} // end of class
