package com.example.controllerexam.controller.exam01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName : com.example.controllerexam.controller.exam01
 * fileName : HelloController
 * author : L.DH
 * date : 2023-10-04
 * description :
 * TODO : JSP, 타임리프 : SSR (Server Side Rendering)
 *  1) 구조 => Springboot 소스가 같이 있음
 *  2) html 파일을 springboot 에서 만들어서 웹브라우저로 전송함
 * <p>
 * TODO : React/ Vue  : CSR (Client Side Rendering)
 *  ) 구조 => 소수가 분리됨
 *  2) html 파일을 최초 1회 전송하고 => 다음부터는 변경되는 부분만 서버에서 받고 나머지는 웹 브라우저에 자체 만듬
 * <p>
 * TODO : @GetMapping(url)함수(){ return "jsp페이지명";}
 *  => CRUD => Read 요청일때 사용하는 어노테이션
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-04         L.DH         최초 생성
 */
@Controller
public class HelloController {
    @GetMapping("/exam01/hello")
    public String Hello(Model model) {
//  TODO : 해쉬맵 자료구조 : (키, 값) => jsp 페이지 변수를 (greeting, greeting2 ... ) 전송
        model.addAttribute("greeting", "안녕 Springboot");
        model.addAttribute("greeting2", "Springboot 처음이지");
        model.addAttribute("greeting3", "수고해!!!");

        return "exam01/hello.jsp";
    }

//  TODO: 연습 1) url : /exam01/hello2 => "exam01/example01.jsp" 에 "안녕 hello2 페이지 " 출력하기
//                                                                 "Springboot 처음이지"
//                                                                 "수고해!!!"
    @GetMapping("/exam01/hello2")
    public String Hello2(Model model) {
        model.addAttribute("greeting", "안녕 hello2 페이지");
        model.addAttribute("greeting2", "Springboot 처음이지");
        model.addAttribute("greeting3", "수고해!!!");

        return "exam01/example01.jsp";
    }

//  TODO: 연습 2) url : /exam01/hello3
//               jsp : "exam01/example02.jsp"
//               결과 :  "안녕 JSP 페이지야 "
//                      "JSP 에는 JSTL "
//                      "EL 표현식이 있습니다. "
    @GetMapping("/exam01/hello3")
    public String Hello3(Model model) {
        model.addAttribute("greeting", "안녕 JSP 페이지야 ");
        model.addAttribute("greeting2", "JSP 에는 JSTL ");
        model.addAttribute("greeting3", "EL 표현식이 있습니다. ");

        return "exam01/example02.jsp";
    }

//  TODO: 예제 2) JSP 페이지로 모든 자료형을 보내기
//            url : /exam01/operation
//            jsp : exam01/operation.jsp
    @GetMapping("/exam01/operation")
    public String Operation(Model model) {

        String strNum = "10";
        int iNum = 100;
        String strVal = "a";
        boolean bVal  = true;

        model.addAttribute("strNum", strNum);
        model.addAttribute("iNum", iNum);
        model.addAttribute("strVal", strVal);
        model.addAttribute("bVal", bVal);

        return "exam01/operation.jsp";
    }

}