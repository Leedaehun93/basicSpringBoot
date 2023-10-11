package com.example.modelexam.controller.exam05;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam05.Dept05Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam05
 * fileName : Dept05Controller
 * author : L.DH
 * date : 2023-10-11
 * description : edition에서 업데이트 버튼 및 url 추가해보기
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         L.DH          최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam05")
public class Dept05Controller {

    //    todo: MVC 의 Model(Service클래스) 객체 가져오기
    @Autowired
    Dept05Service deptService;

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

//      TODO: Service 객체의 전체조회 함수 호출
        List<Dept> list = deptService.findAll();
        model.addAttribute("list", list);

//      TODO: 로그 찍기
        log.debug(list.toString());

        return "exam05/dept/dept_all.jsp";
    }

    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable long dno,
                            Model model
    ) {
//      todo: 서비스 상세조회 호출
        Dept dept = deptService.findById(dno);
        model.addAttribute("dept", dept);
        return "exam05/dept/dept_id.jsp";
    }

    //  todo: 부서 추가 페이지 열기 함수
    @GetMapping("/dept/addition")
    public String addDept() {
        return "exam05/dept/add_dept.jsp";
    }

    //  todo: 저장 버튼 클릭시 db 저장하기 함수
    @PostMapping("/dept/add")
    public RedirectView createDept(@ModelAttribute Dept dept) {
//      todo: 서비스 저장함수 호출
        deptService.save(dept);
//      todo: 저장 후 전체조회 url 로 강제 페이지 이동
//        사용법 : new RedirectView("강제이동될url주소")
        return new RedirectView("/exam05/dept");
    }

    //  todo: 수정 페이지 열기 : 화면이 보일때 데이터도 화면에 미리 출력해야함
    @GetMapping("/dept/edition/{dno}")
    public String editDept(@PathVariable long dno, Model model) {
//      todo: 1) 상세 조회
        Dept dept = deptService.findById(dno); //
        model.addAttribute("dept", dept);
        return "exam05/dept/update_dept.jsp";
    }

    //  todo: 수정 저장 : 리다이렉트(강제 이동) : 전체조회페이지로 이동
    @PutMapping("/dept/edit/{dno}")
    public RedirectView updateDept(@PathVariable long dno,
                                   @ModelAttribute Dept dept) {
//        todo: 수정 저장 함수 호출
        deptService.save(dept);
        return new RedirectView("/exam05/dept");
    }
}