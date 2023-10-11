package com.example.modelexam.controller.exam09;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam09.Dept09Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.controller.exam09
 * fileName : Dept09Controller
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 저장 함수
 * 요약 : react 연동(vue 등)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-11         L.DH         최초 생성
 */

@Slf4j
@RestController
@RequestMapping("/exam09")
public class Dept09Controller {
    //  TODO : 객체 가져오기
    @Autowired
    Dept09Service deptService;

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

}