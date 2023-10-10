package com.example.modelexam.service.exam03;

import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam03
 * fileName : Member03Service
 * author : L.DH
 * date : 2023-10-10
 * description : 회원 서비스 - 업무 로직
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
public class Member03Service {

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
//  todo: 연습 2)
//    Member03Service 클래스를 만들고 findById() 함수를 정의한다.
//    Member03Controller 클래스를 만들어서 getMemberId() 함수를 정의하고,
//    샘플데이터 뷰로(jsp : member_id.jsp) 전송해 보세요.
//    url : /member/{eno}
//    jsp : exam03/member/member_id.jsp

    /**
     * 상세조회(1건조회)
     * @param eno
     * @return
     */
    public Member findById(long eno) {
//      TODO : 상세조회(1건조회)
        Member member = memberDao.selectById(eno);

        return member;
    }

//  todo: 연습 3)
//    Member03Service 클래스를 만들고 save() 함수를 정의한다.
//    Member03Controller 클래스를 만들어서
//    createMember() 함수를 정의하고
//    Rest Client 툴로 데이터를 확인하세요

    /**
     * 회원 저장 함수
     * @param member
     * @return
     */
    public List<Member> save(Member member) {
//      TODO : db 저장
        List<Member> list = memberDao.insert(member);

        return list;
    }

}