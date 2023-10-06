package com.example.controllerexam.controller.exam09;


import com.example.controllerexam.model.Dept;
import com.example.controllerexam.model.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.example.controllerexam.controller.exam09
 * fileName : ObjectResponseEntity2Controller
 * author : L.DH
 * date : 2023-10-06
 * description : ResponseEntity<자료형> 생성자 형태로 내보내기
 * 요약 :
 * ResponseEntity(성공 or 실패 신호 보내기)
 * 결과 데이터와 HTTP 상태 코드를 직접 제어할 수 있는 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-06         L.DH         최초 생성
 */
@RestController
@RequestMapping("/examp09")
public class ObjectResponseEntity2Controller {
    @PostMapping("/objet-body")
    public ResponseEntity<Object>
    getObjectRequestBody(
            @RequestBody Member member
    ) {
        try {
            List<Member> list = new ArrayList<>();
            list.add(member);
//          TODO : 성공 : OK(200)
            if (member != null) {
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//          TODO : 0건 insert : NO_CONTENT(204)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//          TODO : BAD_REQUEST(400)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//  TODO: 연습 1) 부서 클래스(Dept) 의 정보를 Post 방식으로 제공받고 List 넣어
//      Rest Client 로 출력하세요
//    단, 예외 처리 코딩을 하되 List 가 null 이 아닐 경우 상태메세지를 FOUND(302),
//    실패 메세지는 NO_CONTENT(204) 로 하고,
//    프로그램 에러가(예외) 발생 시 INTERNAL_SERVER_ERROR(500) 코딩하세요.

@PostMapping("/object-body-dept")
    public ResponseEntity<Object>
    getExam01(
        @RequestBody Dept dept
        ) {
        try {
            List<Dept> list = new ArrayList<>();
            list.add(dept);
//          TODO : 성공 : FOUND(302)
            if (dept != null) {
                return new ResponseEntity<>(HttpStatus.FOUND);
            } else {
//          TODO : 0건 insert : NO_CONTENT(204)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
//          TODO : INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
}
