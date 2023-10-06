package com.example.controllerexam.controller.exam06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


/**
 * packageName : com.example.controllerexam.controller.exam06
 * fileName : MultiPathVariableController
 * author : L.DH
 * date : 2023-10-05
 * description : 2개 이상 @PathVariable 사용 예제
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-05         L.DH         최초 생성
 */
@Controller
@RequestMapping("/exam06")
public class MultiPathVariableController {
//  TODO: 예제 : id, name 2개 매개변수 전달해서 jsp 출력
//   url 테스트 : http://localhost:8000/exam06/multi-path/id/hong/name/honggildong
    @GetMapping("/multi-path/id/{id}/name/{name}")
    public String getMultiVar(
            @PathVariable String id,
            @PathVariable String name,
            Model model
    ) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "exam06/multi_path.jsp";
    }


    // TODO: 아래 url 를 보고 함수를 작성하세요
//   jsp 에 전달시 list 배열에 담아 부트스트랩 테이블로 출력하세요
//   url : /example01/dno/{dno}/dName/{dName}/loc/{loc}
//   jsp : exam06/example01.jsp
//   URL 테스트:  http://localhost:8000/exam06/example01/dno/10/dname/Sales/loc/Pusan
    @GetMapping("/example01/dno/{dno}/dname/{dname}/loc/{loc}")
    public String getExample01(
            @PathVariable int dno,
            @PathVariable String dname,
            @PathVariable String loc,
            Model model
    ) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(dno));
        list.add(dname);
        list.add(loc);

        model.addAttribute("list", list);

        return "exam06/example01.jsp";
    }

    // TODO: 예제2 Jsp library 사용법
    @GetMapping("/etc")
    public String getEtc(Model model) {
        return "exam06/etc.jsp";
    }
}
