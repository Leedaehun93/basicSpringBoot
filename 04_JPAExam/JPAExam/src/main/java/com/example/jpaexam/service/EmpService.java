package com.example.jpaexam.service;

import com.example.jpaexam.model.Emp;
import com.example.jpaexam.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service
 * fileName : EmpService
 * author : L.DH
 * date : 2023-10-16
 * description : 회원 업무 서비스
 * 요약 : JPA를 이용한 기본 CRUD
 * 1. Repository 전체 조회
 * 2. Repository 상세 조회
 * 3. Repository 저장 함수
 * 4. Repository 수정 함수
 * 5. Repository 삭제 함수
 *
 * todo: 연습1) 부서 클래스를 참고하여 사원 모델을(Emp) 만들고,
 *   empRepository, empService, empController 를 작성하세요
 *   전체 조회 함수 만드세요
 *   (시퀀스명 : SQ_EMP,
 *    시퀀스함수명 : SQ_EMP_GENERATOR )
 *   url : /emp
 * <p>
 * todo: 연습 2) 부서 클래스를 참고하여 상세조회, 저장/수정 기능을 사원 모델에 추가하세요
 *   상세조회 url : /emp/{eno}
 *     저장  url : /emp
 *     수정  url : /emp/edit/{eno}
 *
 * todo: 연습 3) 부서 클래스를 참고하여 사원 모델에 삭제 기능을 추가하세요
 *   url : /emp/delete/{eno}
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-16         L.DH         최초 생성
 */
@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;  // DI 객체 가져오기

    /** 전체 조회 */
    public List<Emp> findAll() {
        List<Emp> list = empRepository.findAll(); // db 전체 조회 함수 호출

        return list;
    }

    /** 상세 조회 */
    public Optional<Emp> findById(int eno) {
        Optional<Emp> optionalEmp = empRepository.findById(eno);

        return optionalEmp;
    }

    /** 저장 함수 */
    public Emp save(Emp emp){
//        TODO : jap 저장함수 호출( 기본키 없으면 insert, 있으면 update )
        Emp emp2 = empRepository.save(emp);

        return emp2; // 저장된 부서객체
    }

    /**
     * 삭제함수
     */
    public boolean removeById(int eno) {

//      existsById : jpa 함수 - 리턴값: 있으면 true, 없으면 false
        if (empRepository.existsById(eno)) {
            empRepository.deleteById(eno); // DB 삭제(eno)
            return true;
        }
        return false;
    }

} // end of class