package com.example.jpaexam.service;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.model.Emp;
import com.example.jpaexam.repository.DeptRepository;
import com.example.jpaexam.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.jpaexam.service
 * fileName : EmpService
 * author : L.DH
 * date : 2023-10-16
 * description : 부서 업무 서비스
 * 요약 :
 *
 * todo: 연습1) 부서 클래스를 참고하여 사원 모델을(Emp) 만들고,
 *   empRepository, empService, empController 를 작성하세요
 *   전체 조회 함수 만드세요
 *   (시퀀스명 : SQ_EMP,
 *    시퀀스함수명 : SQ_EMP_GENERATOR )
 *   url : /emp
 * <p>
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
}