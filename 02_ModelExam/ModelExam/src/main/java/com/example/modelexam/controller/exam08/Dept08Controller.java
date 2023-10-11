package com.example.modelexam.controller.exam08;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam08.Dept08Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.controller.exam08
 * fileName : Dept08Controller
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 상세 조회(1건 조회)
 * 요약 : react 연동(vue 등) + null 방지 기능 추가
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-11         L.DH         최초 생성
 */

@Slf4j
@RestController
@RequestMapping("/exam08")
public class Dept08Controller {
    //  TODO : 객체 가져오기
    @Autowired
    Dept08Service deptService;

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

}