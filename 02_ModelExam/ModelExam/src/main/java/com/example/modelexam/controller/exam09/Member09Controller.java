package com.example.modelexam.controller.exam09;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam09.Member09Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam09
 * fileName : Member09Controller
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
public class Member09Controller {
// TODO : 객체 가져오기
    @Autowired
    Member09Service memberService;

    /**
     * 저장 함수
     */
    @PostMapping("/member")
    public ResponseEntity<Object> createDept(
            @RequestBody Member member) {
        try {
            List<Member> list = memberService.save(member);
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            log.debug(e.getMessage());
//          TODO : INTERNAL_SERVER_ERROR(500) : sql 구문 에러 등
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
