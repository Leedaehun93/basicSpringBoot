package com.example.modelexam.service.exam08;

import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.service.exam08
 * fileName : Member08Service
 * author : L.DH
 * date : 2023-10-11
 * description : @RestController 상세 조회(1건 조회)
 * 요약 : react 연동(vue 등) + null 방지 기능 추가
 * todo: 연습문제 2)부서클래스를 참고하여
 *  Member08Service 클래스를 만들고 findById() 함수안에 Optional 사용으로
 *  코드를 업그레이드 하세요
 *  Member08Controller 클래스를 만들어서 getMemberId() 함수를 정의하세요
 *  단, 예외처리와 ResponseEntity 를 사용해 데이터와 메세지를 같이 전송하세요
 *  url: /member/{eno}
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         L.DH          최초 생성
 */
@Service
public class Member08Service {

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
    public Optional<Member> findById(long eno) {
//       TODO : db 상세조회(1건조회) 함수 호출
//          id(기본키)로 조회
        Member member = memberDao.selectById(eno);
//      todo 추가 : null 방지 클래스 사용
        Optional<Member> optionalMember = Optional.ofNullable(member);
//      todo 추가 : return 수정
        return optionalMember;
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
     *
     * @param eno
     * @return
     */
    public boolean removeById(int eno) {
        int iCount = memberDao.deleteById(eno); // db 삭제

        return (iCount > 0) ? true : false;
    }
}