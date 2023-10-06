package com.example.controllerexam.controller.exam02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * packageName : com.example.controllerexam.controller.exam02
 * fileName : ParamController
 * author : L.DH
 * date : 2023-10-05
 * description : @RequestMapping(공동url), @RequestParam(쿼리스트링 방식)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-05         L.DH         최초 생성
 */
@Controller
// TODO : @RequestMapping("/공통url") : 공통url 함수의 url 과 합쳐져서 사용됨
//   예) @RequestMapping("/exam02") + @GetMapping("/hello-name")
//       => url : /exam02/hello-name
@RequestMapping("/exam02")

public class ParamController {
// TODO : 쿼리스트링 방식 : url?변수명 = 값 => 다른 jsp 페이지로 값을 전달 할 수 있음
// TODO : (vs 파라메터 방식   : url/값        => 다른 jsp 페이지로 값을 전달 할 수 있음 )
//     @RequestParam : 쿼리스트링 방식으로 변수에 값을 저장해서 다른 페이지로 전달하는 어노테이션
//      사용법 : 함수명(Model model, @RequestParam String 변수명){}
//              url? 변수명 = 값(웹 브라우저 주소창 입력)
//      옵션 : defaultValue = " " : 쿼리스트링 변수에 값이 null 이면 " " 바꿔줌
//      url 테스트 : http://localhost:8000/exam02/hello-name?name=홍길동
    @GetMapping("hello-name")
    public String HelloName(Model model
            , @RequestParam(defaultValue = "") String name) {
        model.addAttribute("greeting", "안녕하세요 " + name);

        return "exam02/hello.jsp";
    }

//  TODO: 연습 1) url : /exam02/hello-dname
//               jsp : exam02/example01.jsp
//               문제 : dname(부서명)의 값을 url 쿼리스트링으로 전달해서
//                example01.jsp 에 출력해 보세요
//               결과 : 부서명 : Sales
@GetMapping("hello-dname")
    public String Dname(Model model
                        , @RequestParam(defaultValue = "") String dname) {
        model.addAttribute("greeting","부서명 : " + dname);

        return "exam02/example01.jsp";
}

//  TODO: 연습 2) 숫자로 url 매개변수를 전달해서 화면에 출력해 보세요.
//         url : /exam02/hello-no
//         jsp : exam02/example02.jsp
//         결과 : 20
//    url 테스트 : http://localhost:8000/exam02/hello-no?no=20

    @GetMapping("hello-no")
    public String HelloNo(Model model
                       , @RequestParam(defaultValue = "0") int no) {
        model.addAttribute("greeting", "번호 : " + no);

        return "exam02/example02.jsp";
    }

}
