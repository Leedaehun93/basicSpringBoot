package com.example.controllerexam.controller.exam03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.example.controllerexam.controller.exam03
 * fileName : MultiParamController
 * author : L.DH
 * date : 2023-10-05
 * description :  @RequestMapping, @RequestParam 2개 이상 사용 예제
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-05         L.DH         최초 생성
 */
@Controller
// TODO : @RequestMapping("/공통url")
@RequestMapping("/exam03")
public class MultiParamController {

    //    TODO: 예제1 : URL 매개변수 2개를 각각 키 이름으로 전달
//       URL 테스트 : http://localhost:8000/exam03/hello-name-id?name=kang&id=forbob
    @GetMapping("/hello-name-id")
    public String setHelloNameId(Model model,
                                 @RequestParam(defaultValue = "") String name,
                                 @RequestParam(defaultValue = "") String id
    ) {
        model.addAttribute("attrName", "이름 : " + name);
        model.addAttribute("attrId", "이름 : " + id);

        return "exam03/hello_name_id.jsp";
    }

    //  TODO: 연습 1) URL 매개변수로 dno=10, dName=Accounting Loc=NewYork 받았다. 아래 결과를 화면에 출력하세요.
//         url : /example01
//         jsp : exam03/example01.jsp
//         결과 :
//          부서번호 : 10
//          부서명 : Accounting
//          위치 : NewYork
//   url 테스트 : http://localhost:8000/exam03/example01?dno=10&dname=Accounting&loc=NewYork
    @GetMapping("/example01")
    public String setExample01(Model model,
                               @RequestParam(defaultValue = "0") int dno,
                               @RequestParam(defaultValue = "") String dname,
                               @RequestParam(defaultValue = "") String loc
    ) {
        model.addAttribute("dno", "부서번호 : " + dno);
        model.addAttribute("dname", "부서이름 : " + dname);
        model.addAttribute("loc", "부서지역 : " + loc);

        return "exam03/example01.jsp";
    }

    //  TODO: 예제 2) URL 매개변수를 ArrayList 로 View 에 전달
//   URL 테스트 : http://localhost:8000/exam03/hello-array?name=kang&id=forbob
    @GetMapping("/hello-array")
    public String setHelloArray(Model model,
                                @RequestParam(defaultValue = "") String name,
                                @RequestParam(defaultValue = "") String id
    ) {
        List<String> list = new ArrayList<>();
        list.add(name);
        list.add(id);

        model.addAttribute("list", list);

        return "exam03/hello_array.jsp";
    }

    //  TODO: 연습2) 연습 1에서 작성한 dno, dname, loc 를 ArrayList 담아서 jsp 전달하세요
//    화면에 출력시 부트스트랩 테이블을 이용해서 출력하세요.
//    url : /example02
//    jsp : exam03/example02.jsp
//    url 테스트 : http://localhost:8000/exam03/example02?dno=10&dname=Accounting&loc=NewYork
//    힌트) List<String> list = new ArrayList<>();
//        list.add(String.valueOf(dno));    // 숫자 -> 문자열 변환
//    결과 : 테이블 형태로
//      부서번호 : 10
//      부서명 : Accounting
//      위치 : NewYork
    @GetMapping("/example02")
    public String setExample02(Model model,
                               @RequestParam(defaultValue = "") int dno,
                               @RequestParam(defaultValue = "") String dname,
                               @RequestParam(defaultValue = "") String loc
    ) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(dno));
        list.add(dname);
        list.add(loc);

        model.addAttribute("list", list);
        return "exam03/example02.jsp";
    }

    //  TODO: 연습 3) 아래 결과를 ArrayList 담아서 jsp 전달하세요
//    화면에 출력시 부트스트랩 테이블을 이용해서 출력하세요
//    url : /example03
//    jsp : exam03/example03.jsp
//    url 테스트 : http://localhost:8000/exam03/example03?eno=7788&ename=Scott&salary=3000&job=Manager
//    결과 : 테이블 형태로
//      사원번호 : 7788
//      사원명 : Scott
//      월급 : 3000
//      직위 : Manager
    @GetMapping("/example03")
    public String setExample03(Model model,
                               @RequestParam(defaultValue = "0") int eno,
                               @RequestParam(defaultValue = "") String ename,
                               @RequestParam(defaultValue = "0") int salary,
                               @RequestParam(defaultValue = "") String job
    ) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(eno));
        list.add(ename);
        list.add(String.valueOf(salary));
        list.add(job);

        model.addAttribute("list", list);
        return "exam03/example03.jsp";
    }

    //   TODO: 예제 3: URL 매개변수 3개를 전달해서 조건에 따라 출력하기
//    URL 테스트 : http://localhost:8000/exam03/condition?name=삼식이&color=brown&kind=dog
    @GetMapping("/condition")
    public String setCondition(Model model,
                               @RequestParam(defaultValue = "") String name,
                               @RequestParam(defaultValue = "") String color,
                               @RequestParam(defaultValue = "") String kind
    ) {
        model.addAttribute("name", name);
        model.addAttribute("color", color);
        model.addAttribute("kind", kind);

        return "exam03/condition.jsp";
    }

    //  TODO: 아래의 결과를 출력하세요, 조건문 이용해서 아래 출력
//    url : /example04
//    jsp : exam03/example04.jsp
//    URL 테스트 : http://localhost:8000/exam03/example04?title=아반떼&color=grey&kind=세단
//    결과 : 아반떼가 맞습니다.
//          회색입니다.
    @GetMapping("/example04")
    public String setExample04(Model model,
                               @RequestParam(defaultValue = "") String title,
                               @RequestParam(defaultValue = "") String color,
                               @RequestParam(defaultValue = "") String kind
    ) {
        model.addAttribute("title", title);
        model.addAttribute("color", color);
        model.addAttribute("kind", kind);

        return "exam03/example04.jsp";
    }
}
