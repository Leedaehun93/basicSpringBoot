package com.example.mybatisexam.controller.exam01;

import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Emp;
import com.example.mybatisexam.model.vo.Emp;
import com.example.mybatisexam.service.exam01.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

/**
 * packageName : com.example.mybatisexam.controller.exam01
 * fileName : EmpController
 * author : L.DH
 * date : 2023-10-12
 * description : CRUD 부서 컨트롤러 : jsp 연동 : @Controller
 * 1. 전체 조회 : like 기능
 * 2. 상세 조회
 * 3. 저장 함수
 * 4. 수정 함수
 * 5. 삭제 함수
 * 요약 :
 * todo: 연습 1)부서클래스를 참고하여
 *     Emp 클래스 ( schema.sql 참고 )
 *     EmpDao 클래스 findByEnameContaining()
 *     emp.xml 클래스
 *     EmpService 클래스를 만들고 findByEnameContaining() 함수를 정의한다.
 *     EmpController 클래스를 만들어서 getEmpAll() 함수를 정의하고,
 *   샘플데이터를 뷰로(emp_all.html) 전송해 보세요.
 * <p>
 * todo: 연습 2) 부서 클래스를 참고해서 사원에 상세조회기능을 추가하세요.
 *         empDao, emp.xml, EmpService, EmpController
 *         (단, xml 에서 공통 sql 문을 이용하세요)
 *    url : /emp/{eno}
 *    jsp : exam01/emp/emp_id.jsp
 *    url test :   URL 테스트 : http://localhost:8000/exam01/emp/7788
 *
 *  todo: 연습3) 부서 클래스를 참고하여 사원에 저장기능을 추가하세요
 *    empDao.java, emp.xml, EmpService, EmpController, add_emp.jsp
 *    사원 추가페이지 url : /emp/addition
 *                 jsp : exam01/emp/add_emp.jsp
 *    사원 db 저장 url : /emp/add
 *      redirect jsp : /exam01/emp
 *
 * todo: 연습 4) 부서 클래스를 참고하여 사원에 수정기능을 추가하세요
 *   empDao, emp.xml, EmpService, EmpController, update_emp.jsp
 *   수정 페이지 url :  /emp/edition/{eno}
 *             jsp : exam01/emp/update_emp.jsp
 *   db 수정 url    : /emp/edit/{eno}
 *     redirect jsp: /exam01/emp
 *
 * todo: 연습 5) 부서 클래스를 참고하여 사원 삭제기능을 추가하세요
 *   empDao, emp.xml, EmpService, EmpController, update_emp.jsp 수정
 *            url : /emp/delete/{eno}
 *   redirect jsp : /exam01/emp
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam01")
public class EmpController {

    @Autowired
    EmpService empService;

    /**
     * 전체 조회 : ename like 기능(+)
     */
    //  todo: @RequestParam - url?변수=값&변수2=값2(쿼리스트링 방식)
    @GetMapping("/emp")
    public String getEmpAll(
            @RequestParam(defaultValue = "") String ename
            , @RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "3") int size
            , Model model
    ) {
//      todo: 페이징 요청 객체에 정보 저장
//        page : 현재페이지 번호, size : 1 페이지당 개수
        PageReq pageReq = new PageReq(page, size);

//      todo: 전체 조회 함수 호출
        PageRes<Emp> pageRes
                = empService.findByEnameContaining(ename, pageReq);
//      todo: jsp 정보전달(부서배열, 페이징정보)
        model.addAttribute("emp", pageRes.getContent());              // 사원배열
        model.addAttribute("currentPage", pageRes.getNumber());       // 현재 페이지 번호
        model.addAttribute("totalItems", pageRes.getTotalElements()); // 전체 테이블 건수
        model.addAttribute("totalPages", pageRes.getTotalPages());    // 전체 페이지 개수
        model.addAttribute("startPage", pageRes.getStartPage());      // 현재 시작 페이지 번호
        model.addAttribute("endPage", pageRes.getEndPage());          // 현재 끝 페이지 번호

        log.debug(model.toString()); // 로그 출력

        return "exam01/emp/emp_all.jsp";
    }

    /**
     * 상세 조회
     */
    @GetMapping("/emp/{eno}")
    public String getEmpId(@PathVariable int eno,
                           Model model
    ) {
//      서비스 상세 조회 함수 호출
        Optional<Emp> optionalEmp = empService.findById(eno);
        model.addAttribute("emp", optionalEmp.get());

        return "exam01/emp/emp_id.jsp";
    }

    /**
     * 저장 함수 : 저장 페이지로 이동
     */
    @GetMapping("/emp/addition")
    public String addEmp() {
        return "exam01/emp/add_emp.jsp";
    }
    /**
     * 저장함수 : db 저장
     */
    @PostMapping("/emp/add")
    public RedirectView createEmp(
            @ModelAttribute Emp emp
    ) {
        empService.save(emp);
        // 전체 조회 페이지로 강제 이동
        return new RedirectView("/exam01/emp");
    }

    /** 수정 함수 : 수정 페이지로 이동 + 상세조회(1건조회) */
    @GetMapping("/emp/edition/{eno}")
    public String editEmp(@PathVariable int eno,
                           Model model
    ) {
//      서비스 상세조회 함수 호출
        Optional<Emp> optionalEmp = empService.findById(eno);
//      jsp 전달
        model.addAttribute("emp", optionalEmp.get());
        return "exam01/emp/update_emp.jsp";
    }
    /** 수정 함수 : db 수정 저장 */
    @PutMapping("/emp/edit/{eno}")
    public RedirectView updateEmp(@PathVariable int eno,
                                   @ModelAttribute Emp emp
    ) {
        empService.save(emp); // db 수정 저장
//      전체 조회 페이지로 강제 이동
        return new RedirectView("/exam01/emp");
    }

    /** 삭제 함수 */
    @DeleteMapping("/emp/delete/{eno}")
    public RedirectView deleteEmp(@PathVariable int eno) {
        empService.removeById(eno); // db 삭제

        return new RedirectView("/exam01/emp");
    }

}