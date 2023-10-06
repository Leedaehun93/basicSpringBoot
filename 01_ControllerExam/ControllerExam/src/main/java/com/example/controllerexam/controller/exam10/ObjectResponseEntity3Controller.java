package com.example.controllerexam.controller.exam10;

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
 * packageName : com.example.controllerexam.controller.exam10
 * fileName : ObjectResponseEntity3Controller
 * author : L.DH
 * date : 2023-10-06
 * description : ResponseEntity<자료형> 함수 형태로 내보내기
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
@RequestMapping("/examp10")
public class ObjectResponseEntity3Controller {
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
                return ResponseEntity.ok().body(list);
            } else {
//          TODO : 0건 insert : NO_CONTENT(204)
//           디자인패턴 : 빌더 패턴(생성자 대신 사용하는 기능)
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
//          TODO : BAD_REQUEST(400)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
