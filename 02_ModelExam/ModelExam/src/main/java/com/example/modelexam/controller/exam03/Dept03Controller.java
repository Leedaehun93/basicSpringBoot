package com.example.modelexam.controller.exam03;


import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam03.Dept03Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam03
 * fileName : Dept03Controller
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
@RequestMapping("/exam03")
public class Dept03Controller {

// TODO : MVC 의 Model(Service클래스) 객체 가져오기
    @Autowired
    Dept03Service deptService;

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

//      TODO : Service 객체의 전체조회 함수 호출
        List<Dept> list = deptService.findAll();
        model.addAttribute("list", list);

//      TODO : 로그 찍기
        log.debug(list.toString());

        return "exam03/dept/dept_all.jsp";
    }

    @GetMapping("/dept/{dno}")
    public String getDeptId(@PathVariable long dno,
                            Model model
    ) {
//      TODO : 서비스 상세조회 호출
        Dept dept = deptService.findByid(dno);
        model.addAttribute("dept", dept);

        return "exam03/dept/dept_id.jsp";
    }

//  TODO : @ResponseBody : 함수의 결과로 json 데이터를 리턴하고자 할 때 사용하는 어노테이션
//   사용법 : 함수의 위에 붙이기
    @PostMapping("/dept")
    @ResponseBody
    public List<Dept> createDept(
            @RequestBody Dept dept
    ) {
        List<Dept> list = deptService.save(dept);

        return list;
    }

}