package com.example.modelexam.dao;

import com.example.modelexam.model.Member;
import com.example.modelexam.testdata.SampleMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.modelexam.dao
 * fileName : DeptDao
 * author : kangtaegyung
 * date : 2022/10/15
 * description : 샘를 데이터를 직접 조회/추가/삭제/수정하는 기본적인 함수들의 모임(DB 직접 접근 클래스)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/15         kangtaegyung          최초 생성
 */
@Repository
public class MemberDao {

    @Autowired
    SampleMember sampleMember; // 스프링부트 컨테이너에서 샘플 데이터 객체 하나 가져오기

    //    모든 샘를 데이터 조회 함수
    public List<Member> selectAll() {
        List<Member> list = sampleMember.getList();

        return list;
    }

    //    아이디로 조회하는 함수
    public Member selectById(long eno) {
        List<Member> list = sampleMember.getList();

        Member resDept = null;

//        id에 해당하는 값 찾기
        for (Member element : list) {
            if(element.getEno() == eno) {
                resDept = element;
            }
        }

        return resDept;
    }

//    데이터를 저장하는 함수
    public List<Member> insert(Member member) {

        List<Member> list = sampleMember.getList();

        list.add(member);

        sampleMember.setList(list);

        return sampleMember.getList();
    }

//    데이터를 수정하는 함수
    public List<Member> update(Member member) {

        List<Member> list = sampleMember.getList();

        if(member.getEno() != null) {
            //            수정
            for (Member element : list) {
                if ((int)element.getEno() == (int)member.getEno()) {
                    element.setEname(member.getEname());
                    element.setJob(member.getJob());
                    element.setManager(member.getManager());
                    element.setUpdateTime(member.getUpdateTime());
                }
            }
        }

        return list;
    }

//  데이터를 삭제하는 함수
    public int deleteById(int id) {
        List<Member> list = sampleMember.getList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEno() == id) {
                list.remove(i);
                return 1;
            }
        }

        return 0;
    }
}