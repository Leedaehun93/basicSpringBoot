package com.example.controllerexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * packageName : com.example.helloworld.controller
 * fileName : HelloWorldController
 * author : GGG
 * date : 2023-10-04
 * description : Hello World Controller
 * 요약 :
 *      url 에 해당하는 jsp 파일로 연결하기
 *      @명칭 : 자바의 어노테이션이라고 하고, 주로 함수/클래스/변수 위에 붙여서 사용함
 *        작은 기능이 함수에 추가됨
 *        목적 : 사용하면 코딩량이 획기적으로 줄어듬
 *      @Controller : 클래스에 컨트롤러 기능을 부여하는 어노테이션
 *      @GetMapping("url")함수(){ return "jsp페이지명"; }
 *      => url이 웹브라우저 주소창에 입력되면 -> jsp페이지가 화면에 출력됨
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-04         GGG          최초 생성
 */
@Controller
public class HelloWorldController {

    @GetMapping("/exam00/hello")
    public String Hello(Model model) {
        return "/exam00/hello.jsp";
    }


//  TODO: 연습) url : "/exam00/hello2
//          => jsp : "/exam00/example01.jsp" : 화면에 Hello JSP & Spring boot 출력
//         함수를 만들어 주세요.
    @GetMapping("/exam00/hello2")
    public String Hello2(Model model) {
        return "/exam00/example01.jsp";
    }

}