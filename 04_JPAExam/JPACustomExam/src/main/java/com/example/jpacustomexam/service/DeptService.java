package com.example.jpacustomexam.service;

import com.example.jpacustomexam.dto.DeptGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.service
 * fileName : DeptService
 * author : L.DH
 * date : 2023-10-17
 * description : 부서 서비스
 * 요약 :
 * 1. JPA 쿼리 메소드 전체 조회 + 정렬(내림차순, 내림차순)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-17         L.DH         최초 생성
 */
@Service
public class DeptService {

    @Autowired
    DeptRepository deptRepository; // DI

    /**
     * 1) 전체 조회 + 정렬(부서번호 내림차순(Desc))
     */
//    쿼리메소드 사용한 함수
    public List<Dept> findAllByOrderByDnoDesc() {
        List<Dept> list = deptRepository.findAllByOrderByDnoDesc();

        return list;
    }

    /**
     * 2) 전체 조회 + 정렬(부서명 내림차순(Desc))
     */
//    쿼리메소드 사용한 함수
    public List<Dept> findAllByOrderByDnameDesc() {
        List<Dept> list = deptRepository.findAllByOrderByDnameDesc();

        return list;
    }

    /**
     * 3) 전체 조회 + 정렬(부서번호 오름차순(ASC 생략가능))
     */
//    쿼리메소드 사용한 함수
    public List<Dept> findAllByOrderByDno() {
        List<Dept> list = deptRepository.findAllByOrderByDno();

        return list;
    }

    /**
     * 4) 전체조회 + dname like(Containing) 검색 + 정렬(dname 내림차순) 조회
     */
//    쿼리메소드 사용한 함수
    public List<Dept> findAllByDnameContainingOrderByDnameDesc(String dname) {
        List<Dept> list = deptRepository.findAllByDnameContainingOrderByDnameDesc(dname);

        return list;
    }

    /**
     * 전체조회 + dname like 검색 : @Query
     */
    public List<Dept> selectByDname(String dname) {
        List<Dept> list
                = deptRepository.selectByDname(dname);

        return list;
    }

    /**
     * 전체조회 + dname like 검색 : @Query
     */
    public List<Dept> selectByDnameAndLoc(String dname, String loc) {
        List<Dept> list
                = deptRepository.selectByDnameAndLoc(dname, loc);

        return list;
    }

    /**
     * 전체조회 그룹 함수 검색(dto) : @Query
     */
    public List<DeptGroupDto> selectByGroupFunc() {
        List<DeptGroupDto> list
                = deptRepository.selectByGroupFunc();

        return list;
    }

    /**
     * 5) 전체조회 기본 함수 검색(dto) : @Query
     */
    public List<DeptGroupDto> selectByBasicFunc() {
        List<DeptGroupDto> list
                = deptRepository.selectByBasicFunc();

        return list;
    }

    /**
     * 6) 전체조회 case when 검색(dto) : @Query
     */
    public List<DeptGroupDto> selectByCase() {
        List<DeptGroupDto> list
                = deptRepository.selectByCase();

        return list;
    }


} // end of class
