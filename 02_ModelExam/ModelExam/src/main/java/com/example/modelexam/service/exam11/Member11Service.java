package com.example.modelexam.service.exam11;

import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.service.exam11
 * fileName : Member11Service
 * author : L.DH
 * date : 2023-10-12
 * description : @RestController 업데이트(수정) 기능
 * 요약 : react 연동(vue 등)
 * todo: 연습문제 5)부서클래스를 참고하여
 *     Member11Controller 클래스를 만들어서 deleteMember() 함수를 정의하세요
 *    단, 예외처리와 ResponseEntity 를 사용해 데이터와 메세지를 같이 전송하세요
 *    url : /member/delete/{eno}
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-12         L.DH          최초 생성
 */
@Service
public class Member11Service {

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