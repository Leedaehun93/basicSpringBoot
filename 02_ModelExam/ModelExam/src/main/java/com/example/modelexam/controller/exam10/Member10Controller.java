package com.example.modelexam.controller.exam10;

import com.example.modelexam.model.Dept;
import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam10.Member10Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam10
 * fileName : Member10Controller
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 업데이트(수정) 기능
 * 요약 : react 연동(vue 등)
 * todo: 연습문제 4)부서클래스를 참고하여
 *    Member10Controller 클래스를 만들어서 updateMember() 함수를 정의하세요
 *    단, 예외처리와 ResponseEntity 를 사용해 데이터와 메세지를 같이 전송하세요
 *    url : /member/edit/{eno}
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-11         L.DH         최초 생성
 */

@Slf4j
@RestController
@RequestMapping("/exam10")
public class Member10Controller {
    // TODO : 객체 가져오기
    @Autowired
    Member10Service memberService;

    /**
     * 수정 함수
     */
    @PutMapping("/member/edit/{eno}")
    public ResponseEntity<Object> updateDept(
            @PathVariable int eno,
            @RequestBody Member member
    ) {
        try {
            List<Member> list = memberService.save(member);
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
