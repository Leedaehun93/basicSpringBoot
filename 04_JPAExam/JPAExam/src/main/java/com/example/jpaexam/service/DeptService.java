package com.example.jpaexam.service;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.jpaexam.service
 * fileName : DeptService
 * author : L.DH
 * date : 2023-10-16
 * description : 부서 업무 서비스
 * 요약 :
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

    /** 전체 조회 */
    public List<Dept> findAll() {
        List<Dept> list = deptRepository.findAll(); // db 전체 조회 함수 호출

        return list;
    }
}
