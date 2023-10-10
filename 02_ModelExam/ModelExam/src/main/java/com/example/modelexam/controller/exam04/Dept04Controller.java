package com.example.modelexam.controller.exam04;


import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam04.Dept04Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam04
 * fileName : Dept04Controller
 * author : L.DH
 * date : 2023-10-10
 * description : 부서 컨트롤러 - 화면 & 업무로직 중간 역할(리모콘 역할)
 *
 * @Slf4j, findAll()
 * 요약 : Servvice 객체의 전체조회 함수 호출
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-10         L.DH         최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam04")
public class Dept04Controller {

// TODO : MVC 의 Model(Service클래스) 객체 가져오기
    @Autowired
    Dept04Service deptService;

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

//      TODO : Service 객체의 전체조회 함수 호출
        List<Dept> list = deptService.findAll();
        model.addAttribute("list", list);

//      TODO : 로그 찍기
        log.debug(list.toString());

        return "exam04/dept/dept_all.jsp";
    }

    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable long dno,
                            Model model
    ) {
//      TODO : 서비스 상세조회 호출
        Dept dept = deptService.findByid(dno);
        model.addAttribute("dept", dept);

        return "exam04/dept/dept_id.jsp";
    }

//  TODO : 부서 추가 페이지 열기 함수
    @GetMapping("/dept/addition")
    public String addDept() {
        return "exam04/dept/add_dept.jsp";
    }

//  TODO : 저장 버튼 클릭시 db 저장하기 함수
    @PostMapping("/dept/add")
    public RedirectView createDept(@ModelAttribute Dept dept) {
//  TODO : 서비스 저장함수 호출
        deptService.save(dept);
//  TODO : 저장 후 전체조회 url 로 강제 페이지 이동
//  사용법 : new RedirectView("강제이동될url주소")

        return new RedirectView("/exam04/dept");
    }


}