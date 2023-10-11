package com.example.modelexam.controller.exam08;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam08.Member08Service;
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
 * fileName : Member08Controller
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 상세 조회(1건 조회)
 * 요약 : react 연동(vue 등) + null 방지 기능 추가
 * todo: 연습문제 2)부서클래스를 참고하여
 *  Member08Service 클래스를 만들고 findById() 함수안에 Optional 사용으로
 *  코드를 업그레이드 하세요
 *  Member08Controller 클래스를 만들어서 getMemberId() 함수를 정의하세요
 *  단, 예외처리와 ResponseEntity 를 사용해 데이터와 메세지를 같이 전송하세요.
 *  url: /member/{eno}
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-11         L.DH         최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/exam08")
public class Member08Controller {
    // TODO : 객체 가져오기
    @Autowired
    Member08Service memberService;

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
     * 상세 조회(1건 조회)
     */
    @GetMapping("/member/{eno}")
    public ResponseEntity<Object> getMemberId(
            @PathVariable long eno
    ) {
        try {
            Optional<Member> optionalMember = memberService.findById(eno);
            if (optionalMember.isEmpty() == false) {
//          TODO : 조회 성공
                return new ResponseEntity<>(optionalMember.get(), HttpStatus.OK);
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
