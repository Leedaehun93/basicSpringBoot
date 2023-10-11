package com.example.modelexam.service.exam07;

import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam07
 * fileName : Member07Service
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 전체 조회
 * 요약 : react 연동(vue 등)
 * todo: 연습문제 1)부서클래스를 참고하여
 *  Member07Controller 클래스를 만들어서 getMemberAll() 함수를 정의하세요
 *  단, 예외처리와 ResponseEntity 를 사용해 데이터와 메세지를 같이 전송하세요
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         L.DH          최초 생성
 */
@Service
public class Member07Service {

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