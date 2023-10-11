package com.example.modelexam.controller.exam07;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam07.Member07Service;
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
 * fileName : Member07Controller
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 전체 조회
 * 요약 : react 연동(vue 등)
 * todo: 연습문제 1)부서클래스를 참고하여
 *  Member07Controller 클래스를 만들어서 getMemberAll() 함수를 정의하세요
 *  단, 예외처리와 ResponseEntity 를 사용해 데이터와 메세지를 같이 전송하세요
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-11         L.DH         최초 생성
 */

@Slf4j
@RestController
@RequestMapping("/exam07")
public class Member07Controller {
    /**
     * 객체 가져오기
     */
    @Autowired
    Member07Service memberService;

    /**
     * 전체 조회 함수
     */
    @GetMapping("/member")
    public ResponseEntity<Object> getMemberAll() {
        try {
            List<Member> list = memberService.findAll();
            if (list.isEmpty() == false) {
//          TODO : 조회 성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//          TODO : 데이터 없음
                return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//          TODO: INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}