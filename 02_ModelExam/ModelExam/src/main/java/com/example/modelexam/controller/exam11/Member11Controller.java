package com.example.modelexam.controller.exam11;

import com.example.modelexam.model.Dept;
import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam11.Member11Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam11
 * fileName : Member11Controller
 * author : L.DH
 * date : 2023-10-12
 * description : @RestController 업데이트(수정) 기능
 * 요약 : react 연동(vue 등)
 * todo: 연습문제 5)부서클래스를 참고하여
 *     Member11Controller 클래스를 만들어서 deleteMember() 함수를 정의하세요
 *    단, 예외처리와 ResponseEntity 를 사용해 데이터와 메세지를 같이 전송하세요
 *    url : /member/delete/{eno}
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */

@Slf4j
@RestController
@RequestMapping("/exam11")
public class Member11Controller {
    // TODO : 객체 가져오기
    @Autowired
    Member11Service memberService;

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
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//          TODO: INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * 삭제 함수
     */
    @DeleteMapping("/member/delete/{eno}")
    public ResponseEntity<Object> deleteMember(
            @PathVariable int eno
    ) {
        try {
            boolean bSuccess = memberService.removeById(eno);

            if (bSuccess == true) {
//              todo: 삭제 성공 : OK(200)
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//              todo: 삭제할 데이터 없음 : NO_CONTENT(203)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//          todo: INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
