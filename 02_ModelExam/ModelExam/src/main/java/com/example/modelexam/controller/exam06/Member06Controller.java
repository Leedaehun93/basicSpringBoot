package com.example.modelexam.controller.exam06;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam06.Member06Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam06
 * fileName : Member06Controller
 * author : L.DH
 * date : 2023-10-11
 * description : edition에서 삭제 버튼 및 url 추가해보기
 * 요약 :
 *  todo: 연습 6)
 *    Member06Service 클래스를 만들고 removeById() 함수를 정의한다.
 *    Member06Controller 클래스를 만들어서 deleteMember() 함수를 정의
 *    update_member.jsp 삭제버튼과 url 를 추가한다.
 *    editMember()
 *    - url : /member/delete/{eno}
 *    - redirect url : /exam06/member
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-11         L.DH         최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam06")
public class Member06Controller {

    //   todo: 서비스 객체 가져오기
    @Autowired
    Member06Service memberService;

    @GetMapping("/member")
    public String getMemberAll(Model model) {

        List<Member> list = memberService.findAll();
        model.addAttribute("list", list);

//      todo: 로깅
        log.debug(list.toString());

        return "exam06/member/member_all.jsp";
    }

    @GetMapping("/member/{eno}")
    public String getMemberId(@PathVariable int eno,
                              Model model) {
//      todo: 멤버 서비스 상세조회 함수 호출
        Member member = memberService.findById(eno);
        model.addAttribute("member", member);

        return "exam06/member/member_id.jsp";
    }

    //  todo: 새로운 회원 추가 페이지 이동 함수
    @GetMapping("/member/addition")
    public String addMember() {
        return "exam06/member/add_member.jsp";
    }

    //  todo: db 저장 함수
    @PostMapping("/member/add")
    public RedirectView createMember(
            @ModelAttribute Member member
    ) {
        memberService.save(member);
//      todo : 전체 조회 페이지
        return new RedirectView("/exam06/member");
    }

    //  todo: 회원 수정 페이지 열기 함수 : 상세조회 필요
    @GetMapping("/member/edition/{eno}")
    public String editMember(@PathVariable long eno, Model model) {
        Member member = memberService.findById(eno); // 상세조회
        model.addAttribute("member", member);

        return "exam06/member/update_member.jsp";
    }

    //  todo: db 수정 저장 함수 : 수정 후 전체조회페이지로 강제 이동(리다이렉트)
    @PutMapping("/member/edit/{eno}")
    public RedirectView updateMember(@PathVariable int eno,
                                     @ModelAttribute Member member) {
//        todo: db 수정 저장
        memberService.save(member);

        return new RedirectView("/exam06/member");
    }

    //  todo: 삭제 함수 : 전체 조회 페이지로 강제 이동
    @DeleteMapping("/member/delete/{eno}")
    public RedirectView deleteMember(@PathVariable int eno) {
        memberService.removeById(eno); // db 삭제 함수 호출

        return new RedirectView("/exam06/member"); // 전체 조회 사이트
    }
}
