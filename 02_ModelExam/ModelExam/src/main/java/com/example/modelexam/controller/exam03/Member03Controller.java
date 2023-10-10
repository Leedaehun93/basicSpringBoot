package com.example.modelexam.controller.exam03;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam03.Member03Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam03
 * fileName : Member03Controller
 * author : L.DH
 * date : 2023-10-10
 * description :
 * 멤버 컨트롤러 - 화면 & 업무로직 중간 역할(리모콘 역할)
 * @Slf4j, findAll()
 * 요약 : Rest Client 툴로 데이터를 확인
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-10         L.DH         최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam03")

public class Member03Controller {
    //  todo: 연습 1)
//  TODO : 서비스 객체 가져오기
    @Autowired
    Member03Service memberService;

    //  TODO : Servvice 객체의 전체조회 함수 호출
    @GetMapping("/member")
    public String getMemberAll(Model model) {

        List<Member> list = memberService.findAll();
        model.addAttribute("list", list);

//      TODO : 로그 찍기
        log.debug(list.toString());

        return "exam03/member/member_all.jsp";
    }

    //  todo: 연습 2)
    @GetMapping("/member/{eno}")
    public String getMemberId(@PathVariable long eno,
                              Model model) {
//  TODO : 서비스 상세조회 함수 호출
        Member member = memberService.findById(eno);
        model.addAttribute("member", member);
        
        return "exam03/member/member_id.jsp";
    }

//  TODO : @ResponseBody : 함수의 리턴값을 json 데이터로 변경하는 어노테이션     
    //  todo: 연습 3)
    @PostMapping("/member")
    @ResponseBody
    public List<Member> createMember(
            @RequestBody Member member
    ) {
//      TODO : 서비스 저장함수 호출        
        List<Member> list = memberService.save(member);
        
        return list;
    }

}
