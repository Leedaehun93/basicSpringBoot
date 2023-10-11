package com.example.modelexam.controller.exam07;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam07.Dept07Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam07
 * fileName : Dept07Controller
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 전체 조회
 * 요약 : react 연동(vue 등)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-11         L.DH         최초 생성
 */

@Slf4j
@RestController
@RequestMapping("/exam07")
public class Dept07Controller {

    //  TODO : 객체 가져오기
    @Autowired
    Dept07Service deptService;

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
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


