package com.example.modelexam.controller.exam10;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam10.Dept10Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.controller.exam10
 * fileName : Dept10Controller
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 업데이트(수정) 기능
 * 요약 : react 연동(vue 등)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-11         L.DH         최초 생성
 */

@Slf4j
@RestController
@RequestMapping("/exam10")
public class Dept10Controller {

    //  TODO : 객체 가져오기
    @Autowired
    Dept10Service deptService;

    /**
     * 전체 조회 함수
     */
    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll() {
        try {
            List<Dept> list = deptService.findAll();
            if (list.isEmpty() == false) {
//          TODO : 조회 성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//          TODO : 데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//          TODO: INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 상세 조회(1건 조회)
     */
    @GetMapping("/dept/{dno}")
    public ResponseEntity<Object> getDeptId(
            @PathVariable long dno
    ) {

        try {
            Optional<Dept> optionalDept = deptService.findById(dno);
            if (optionalDept.isEmpty() == false) {
//          TODO : 조회 성공
                return new ResponseEntity<>(optionalDept.get(), HttpStatus.OK);
            } else {
//          TODO : 데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//          TODO: INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 저장 함수
     */
    @PostMapping("/dept")
    public ResponseEntity<Object> createDept(
            @RequestBody Dept dept) {
        try {
            List<Dept> list = deptService.save(dept);
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            log.debug(e.getMessage());
//          TODO : INTERNAL_SERVER_ERROR(500) : sql 구문 에러 등
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 수정 함수
     */
    @PutMapping("/dept/edit/{dno}")
    public ResponseEntity<Object> updateDept(
            @PathVariable int dno,
            @RequestBody Dept dept
    ) {
        try {
            List<Dept> list = deptService.save(dept);
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
