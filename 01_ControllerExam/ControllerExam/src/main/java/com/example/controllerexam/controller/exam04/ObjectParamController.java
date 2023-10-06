package com.example.controllerexam.controller.exam04;

import com.example.controllerexam.model.Dept;
import com.example.controllerexam.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName : com.example.controllerexam.controller.exam04
 * fileName : ObjectParamController
 * author : L.DH
 * date : 2023-10-05
 * description : @ModelAttribute : 객체형태로 변환하는 어노테이션
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-05         L.DH         최초 생성
 */

@Controller
@RequestMapping("/exam04")
public class ObjectParamController {
//  TODO: url 테스트 : http://localhost:8000/exam04/object-param?id=forbob&name=kang
//    @ModelAttribute : 객체의 속성명으로 jsp로 각각 전달
//      Member 클래스의 속성명 == url 의 매개변수명 : id , name

    @GetMapping("/object-param")
    public String getObjectParam(
            @ModelAttribute Member member) {
        return "exam04/object_param.jsp";
    }

//  TODO: 연습 1)  모델에 Dept(부서) 클래스를 만들어서 @ModelAttribute 어노테이션으로 전달받고
//    전달 받은 값을 화면에 출력해 보세요.
//   url : /example01
//   jsp : exam04/example01.jsp
//   url 테스트 : http://localhost:8000/exam04/example01?dno=10&dname=Accounting&loc=Daegu
    @GetMapping("/example01")
    public String getExample01(
            @ModelAttribute Dept dept
    ) {
        return "exam04/example01.jsp";
    }

}