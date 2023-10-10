package com.example.modelexam.controller.exam01;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam01.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam01
 * fileName : DeptController
 * author : L.DH
 * date : 2023-10-10
 * description : 부서 컨트롤러 - 화면 & 업무로직 중간 역할(리모콘 역할)
 * @Slf4j, findAll()
 * 요약 : Servvice 객체의 전체조회 함수 호출
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-10         L.DH         최초 생성
 */
// TODO : @Slf4j(최근) - 롬북, 로깅 라이브러리를 위한 어노테이션(디자인 패턴 : 퍼케이드(Facade) 패턴)
//        로깅 라이브러리 : log4j(구) -> log4j2(구-개선), logback -> 함수호출을 일원화 시켜주는 기능
//      사용법 : 클래스 위에 붙이면 사용가능 : log.정보
//          (간략정보 : Error -> Info -> Debug(중간정도의 정보) -> Warn -> Trace : 상세정보)
//    logback 설치 :
//        1) log4jdbc.log4j2.properties, logback-spring.xml 기본 설정 파일 추가
//          - log4jdbc.log4j2.properties : sql 로그를 출력하기 위한 설정파일
//          - logback-spring.xml : logback 의 다양한 레벨 옵션 설정

@Slf4j
@Controller
@RequestMapping("/exam01")
public class DeptController {

    // TODO : MVC 의 Model(Service클래스) 객체 가져오기
    @Autowired
    DeptService deptService;

    @GetMapping("/dept")
    public String getDeptAll(Model model) {

//      TODO : Service 객체의 전체조회 함수 호출
        List<Dept> list = deptService.findAll();
        model.addAttribute("list", list);

//      TODO : 로그 찍기
        log.debug(list.toString());

        return "exam01/dept/dept_all.jsp";
    }
}
