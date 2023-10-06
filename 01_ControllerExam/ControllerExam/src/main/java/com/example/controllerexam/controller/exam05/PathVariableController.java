package com.example.controllerexam.controller.exam05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName : com.example.controllerexam.controller.exam05
 * fileName : PathVariableController
 * author : GGG
 * date : 2023-10-05
 * description : @PathVariable : 파라메터 방식 매개변수 전달하는 어노테이션
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-05         GGG          최초 생성
 */
@Controller
@RequestMapping("/exam05")
public class PathVariableController {
// TODO: url 테스트 : http://localhost:8000/exam05/path-variable/KangTaeGyung
//      => 파라메터 방식 : @GetMapping("/path-variable/{웹매개변수명}")
//      => 웹브라우저 주소창 사용 : url/값
// TODO: 쿼리스트링 : http://localhost:8000/exam05/path-variable?name=KangTaeGyung
    @GetMapping("/path-variable/{name}")
    public String getPathVariable(
            @PathVariable String name,
            Model model) {
        model.addAttribute("name", name);
        return "exam05/path_variable.jsp";
    }

//    TODO: 연습 1) 아래와 같이 URL 이 정의되어 있다. 컨트롤러 함수를 작성하세요.
//    URL 테스트 : http://localhost:8000/exam05/example01/10
//    url : /example01/{num}
//    jsp : exam05/example01.jsp
//    결과 :
//    전달받은 값은 10입니다.

    @GetMapping("/example01/{num}")
    public String getexample01(
            @PathVariable int num,
            Model model) {
        model.addAttribute("num", num);
        return "exam05/example01.jsp";
    }
}