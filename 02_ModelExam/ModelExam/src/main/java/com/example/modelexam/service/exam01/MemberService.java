package com.example.modelexam.service.exam01;


import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam01
 * fileName : MemberService
 * author : L.DH
 * date : 2023-10-10
 * description : 연습1) 회원 서비스 - 업무 로직
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-10         L.DH         최초 생성
 */
//  todo: 연습 1)
//    MemberService 클래스를 만들고 findAll() 함수를 정의한다.
//    MemberController 클래스를 만들어서 getMemberAll() 함수를 정의하고,
//    샘플데이터 뷰로(jsp) 전송해 보세요.
@Service
public class MemberService {

    //    todo : db 접근 함수들이 있는 객체 : memberDao
    @Autowired
    MemberDao memberDao;

    /**
     * 전체 조회
     * @return
     */
    public List<Member> findAll() {
        List<Member> list = memberDao.selectAll(); // 전체 조회

        return list;
    }

}