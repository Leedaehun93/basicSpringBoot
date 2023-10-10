package com.example.modelexam.dao;

import com.example.modelexam.model.Dept;
import com.example.modelexam.testdata.SampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.modelexam.dao
 * fileName : DeptDao
 * author : kangtaegyung
 * date : 2022/10/15
 * description : 샘플 데이터를 직접 조회/추가/삭제/수정하는 기본적인 함수들의 모임(DB 직접 접근 클래스)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/15         kangtaegyung          최초 생성
 */
@Repository
public class DeptDao {

    @Autowired
    SampleData sampleData; // 스프링부트 컨테이너에서 샘플 데이터 객체 하나 가져오기

    //    모든 샘플 데이터 조회 함수
    public List<Dept> selectAll() {
        List<Dept> list = sampleData.getList();

        return list;
    }

    //    아이디로 조회하는 함수
    public Dept selectById(long dno) {
        List<Dept> list = sampleData.getList();

        Dept resDept = null;

//        id에 해당하는 값 찾기
        for (Dept dpt : list) {
            if(dpt.getDno() == dno) {
                resDept = dpt;
            }
        }

        return resDept;
    }

//    데이터를 저장하는 함수
    public List<Dept> insert(Dept dept) {

        List<Dept> list = sampleData.getList();

        list.add(dept);

        sampleData.setList(list);

        return sampleData.getList();
    }

//    데이터를 수정하는 함수
    public List<Dept> update(Dept dept) {

        List<Dept> list = sampleData.getList();

        if(dept.getDno() != null) {
            //            수정
            for (Dept dpt : list) {
                if ((int)dpt.getDno() == (int)dept.getDno()) {
                    dpt.setDname(dept.getDname());
                    dpt.setLoc(dept.getLoc());
                    dpt.setUpdateTime(dept.getUpdateTime());
                }
            }
        }

        return list;
    }

//  데이터를 삭제하는 함수
    public int deleteById(int id) {
        List<Dept> list = sampleData.getList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDno() == id) {
                list.remove(i);
                return 1;
            }
        }

        return 0;
    }
}











