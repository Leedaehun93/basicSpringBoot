package com.example.modelexam.controller.exam04;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam04.Member04Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam04
 * fileName : Member04Controller
 * author : L.DH
 * date : 2023-10-10
 * description : 컨트롤러_추가 및 저장
 * 요약 : 객체의 전체 조회 함수 호출 add 버튼 및 데이터 추가해보기
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-10         L.DH          최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam04")
public class Member04Controller {

//   todo: 서비스 객체 가져오기
    @Autowired
    Member04Service memberService;

    @GetMapping("/member")
    public String getMemberAll(Model model) {

        List<Member> list = memberService.findAll();
        model.addAttribute("list", list);

//      todo: 로깅
        log.debug(list.toString());

        return "exam04/member/member_all.jsp";
    }

    @GetMapping("/member/{eno}")
    public String getMemberId(@PathVariable int eno,
                              Model model) {
//      todo: 멤버 서비스 상세조회 함수 호출
        Member member = memberService.findById(eno);
        model.addAttribute("member", member);

        return "exam04/member/member_id.jsp";
    }

//  todo: 새로운 회원 추가 페이지 이동 함수
    @GetMapping("/member/addition")
    public String addMember() {
        return "exam04/member/add_member.jsp";
    }

//  todo: db 저장 함수
    @PostMapping("/member/add")
    public RedirectView createMember(
            @ModelAttribute Member member
    ){
        memberService.save(member);
//      todo : 전체 조회 페이지
        return new RedirectView("/exam04/member");
    }
}








