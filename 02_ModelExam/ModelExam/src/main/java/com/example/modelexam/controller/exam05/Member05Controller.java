package com.example.modelexam.controller.exam05;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam05.Member05Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam05
 * fileName : MemberController
 * author : DH
 * date : 2023-10-11
 * description : edition에서 업데이트 버튼 및 url 추가해보기
 * 요약 :
 * todo: 연습 5)
 *   Member05Service 클래스를 만들고 save() 함수를 정의한다.
 *   Member05Controller 클래스를 만들어서 editMember(), updateMember() 함수를 정의
 *   editMember()
 *   - url : /member/edition/{eno}
 *   - jsp : exam05/member/update_member.jsp
 *   updateMember()
 *   - url : /member/edit/{eno}
 *   - redirect url : /exam05/member
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         L.DH          최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam05")
public class Member05Controller {

//   todo: 서비스 객체 가져오기
    @Autowired
    Member05Service memberService;

    @GetMapping("/member")
    public String getMemberAll(Model model) {

        List<Member> list = memberService.findAll();
        model.addAttribute("list", list);

//      todo: 로깅
        log.debug(list.toString());

        return "exam05/member/member_all.jsp";
    }

    @GetMapping("/member/{eno}")
    public String getMemberId(@PathVariable int eno,
                              Model model) {
//      todo: 멤버 서비스 상세조회 함수 호출
        Member member = memberService.findById(eno);
        model.addAttribute("member", member);

        return "exam05/member/member_id.jsp";
    }

//  todo: 새로운 회원 추가 페이지 이동 함수
    @GetMapping("/member/addition")
    public String addMember() {
        return "exam05/member/add_member.jsp";
    }

//  todo: db 저장 함수
    @PostMapping("/member/add")
    public RedirectView createMember(
            @ModelAttribute Member member
    ){
        memberService.save(member);
//      todo : 전체 조회 페이지
        return new RedirectView("/exam05/member");
    }

//  todo: 회원 수정 페이지 열기 함수 : 상세조회 필요
    @GetMapping("/member/edition/{eno}")
    public String editMember(@PathVariable long eno, Model model) {
        Member member = memberService.findById(eno); // 상세조회
        model.addAttribute("member", member);

        return "exam05/member/update_member.jsp";
    }

//  todo: db 수정 저장 함수 : 수정 후 전체조회페이지로 강제 이동(리다이렉트)
    @PutMapping("/member/edit/{eno}")
    public RedirectView updateMember(@PathVariable int eno,
                                     @ModelAttribute Member member) {
//        todo: db 수정 저장
        memberService.save(member);

        return new RedirectView("/exam05/member");
    }
}








