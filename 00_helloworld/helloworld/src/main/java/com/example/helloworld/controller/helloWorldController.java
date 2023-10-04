package com.example.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName : com.example.helloworld.controller
 * fileName : hello World Controller
 * author : L.DH
 * date : 2023-10-04
 * description :
 * 요약 :
 * url(웹 브라우저 주소) 에 해당하는 jsp 파일로 연결하기
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-04         L.DH         최초 생성
 */
@Controller
public class helloWorldController {
    @GetMapping("/exam00/hello")
    public String Hello(Model model) {
        return "/exam00/hello.jsp";
    }
}
