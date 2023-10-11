package com.example.modelexam.controller.exam02;

import com.example.modelexam.model.Dept;

import com.example.modelexam.service.exam02.Dept02Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam02
 * fileName : Dept02Controller
 * author : L.DH
 * date : 2023-10-10
 * description : 컨트롤러_상세(1건) 조회
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-10         L.DH         최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam02")
public class Dept02Controller {

    // TODO : MVC 의 Model(Service클래스) 객체 가져오기
    @Autowired
    Dept02Service deptService;

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

//      TODO : Service 객체의 전체조회 함수 호출
        List<Dept> list = deptService.findAll();
        model.addAttribute("list", list);

//      TODO : 로그 찍기
        log.debug(list.toString());

        return "exam02/dept/dept_all.jsp";
    }

    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable long dno,
                            Model model
    ) {
//      TODO : 서비스 상세조회 호출
        Dept dept = deptService.findByid(dno);
        model.addAttribute("dept", dept);

        return "exam02/dept/dept_id.jsp";
    }
}
