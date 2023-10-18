package com.example.jpacustomexam.controller;

import com.example.jpacustomexam.dto.DeptGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.controller
 * fileName : DeptController
 * author : L.DH
 * date : 2023-10-17
 * description : 부서 컨트롤러
 * 요약 :
 * 1. JPA 쿼리 메소드 전체 조회 + 정렬(내림차순, 내림차순)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-17         L.DH         최초 생성
 */
@Slf4j
@RestController
public class DeptController {
    @Autowired
    DeptService deptService; // DI

    /**
     * 1) 전체 조회 + 정렬(부서번호 내림차순(Desc))
     */
    @GetMapping("/dept/dno/desc")
    public ResponseEntity<Object> findAllByOrderByDnoDesc() {
        try {
//            전체 조회 + 정렬(dno 내림차순) 호출
            List<Dept> list = deptService.findAllByOrderByDnoDesc();
            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 2) 전체 조회 + 정렬(부서명 내림차순(Desc))
     */
    @GetMapping("/dept/dname/desc")
    public ResponseEntity<Object> findAllByOrderByDnameDesc() {
        try {
//            전체 조회 + 정렬(dno 내림차순) 호출
            List<Dept> list = deptService.findAllByOrderByDnameDesc();
            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 3) 전체 조회 + 정렬(부서번호 오름차순(ASC 생략가능))
     */
    @GetMapping("/dept/dno/asc")
    public ResponseEntity<Object> findAllByOrderByDno() {
        try {
//            전체 조회 + 정렬(dno 내림차순) 호출
            List<Dept> list = deptService.findAllByOrderByDno();
            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 4) 전체조회 + dname like(Containing) 검색 + 정렬(dname 내림차순) 조회
     */
    @GetMapping("/dept/dname/containing/desc/{dname}")
    public ResponseEntity<Object> findAllByDnameContainingOrderByDnameDesc(
            @PathVariable String dname
    ) {
        try {
//            전체 조회 + 정렬(danme 내림차순) 호출
            List<Dept> list
                    = deptService
                    .findAllByDnameContainingOrderByDnameDesc(dname);
            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 전체조회 + dname like 검색 : @Query
     */
    @GetMapping("/dept/dname/{dname}")
    public ResponseEntity<Object> selectByDname(
            @PathVariable String dname
    ) {
        try {
//            전체 조회 + 정렬(danme 내림차순) 호출
            List<Dept> list
                    = deptService
                    .selectByDname(dname);
            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 전체조회 + dname and loc 검색 : @Query */
    @GetMapping("/dept/dname/{dname}/loc/{loc}")
    public ResponseEntity<Object> selectByDnameAndLoc(
            @PathVariable String dname,
            @PathVariable String loc
    ) {
        try {
            List<Dept> list
                    = deptService.selectByDnameAndLoc(dname, loc);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 전체조회 + 그룹함수(dto) : @Query */
    @GetMapping("/dept/groupfunc")
    public ResponseEntity<Object> selectByDnameAndLoc() {
        try {
            List<DeptGroupDto> list
                    = deptService.selectByGroupFunc();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /** 5) 전체조회 + 일반함수(dto) : @Query */
    @GetMapping("/dept/basicfunc")
    public ResponseEntity<Object> selectByBasicFunc() {
        try {
            List<DeptGroupDto> list
                    = deptService.selectByBasicFunc();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /** 6) 전체조회 + case when(dto) : @Query */
    @GetMapping("/dept/case")
    public ResponseEntity<Object> selectByCase() {
        try {
            List<DeptGroupDto> list
                    = deptService.selectByCase();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


} // end of class
