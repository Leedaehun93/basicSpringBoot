package com.example.modelexam.service.exam06;

import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam06
 * fileName : Member06Service
 * author : L.DH
 * date : 2023-10-11
 * description : edition에서 삭제 버튼 및 url 추가해보기
 * 요약 :
 * todo: 연습 6)
 *  Member06Service 클래스를 만들고 removeById() 함수를 정의한다.
 *  Member06Controller 클래스를 만들어서 deleteMember() 함수를 정의
 *  update_member.jsp 삭제버튼과 url 를 추가한다.
 *  editMember()
 *  - url : /member/delete/{eno}
 *  - redirect url : /exam06/member
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         L.DH          최초 생성
 */
@Service
public class Member06Service {

    //    todo : db 접근 함수들이 있는 객체 : memberDao
    @Autowired
    MemberDao memberDao;

    /**
     * 전체 조회
     *
     * @return
     */
    public List<Member> findAll() {
        List<Member> list = memberDao.selectAll(); // 전체 조회

        return list;
    }

    /**
     * 상세조회(1건조회)
     *
     * @param eno
     * @return
     */
    public Member findById(long eno) {
//      todo: 상세조회(1건조회)
        Member member = memberDao.selectById(eno);

        return member;
    }

    /**
     * 회원 저장 함수
     *
     * @param member
     * @return
     */
    public List<Member> save(Member member) {

        List<Member> list = null;

//      todo: ui(frontend) -> insert (사원번호가 없으면)
        if (member.getEno() == null) {
//          todo: 새로운 사원번호 생성
            int count = memberDao.selectAll().size(); // 전체 건수
            int newEno = count + 8000;
            member.setEno(newEno); // 새로운 사원번호 저장

            //      todo: db 저장
            list = memberDao.insert(member);
        } else {
//            todo: db 수정 저장
            list = memberDao.update(member);
        }

        return list;
    }

    /**
     * 사원번호로 삭제하는 함수
     * @param eno
     * @return
     */
    public boolean removeById(int eno) {
        int iCount = memberDao.deleteById(eno); // db 삭제

        return (iCount > 0) ? true : false;
    }
}