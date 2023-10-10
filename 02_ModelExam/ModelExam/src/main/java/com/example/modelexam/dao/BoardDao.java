package com.example.modelexam.dao;

import com.example.modelexam.model.Board;
import com.example.modelexam.testdata.SampleBoard;
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
public class BoardDao {

    @Autowired
    SampleBoard sampleBoard; // 스프링부트 컨테이너에서 샘플 데이터 객체 하나 가져오기

    //    모든 샘를 데이터 조회 함수
    public List<Board> selectAll() {
        List<Board> list = sampleBoard.getList();

        return list;
    }

    //    아이디로 조회하는 함수
    public Board selectById(int id) {
        List<Board> list = sampleBoard.getList();

        Board resBoard = null;

//        id에 해당하는 값 찾기
        for (Board board : list) {
            if(board.getId() == id) {
                resBoard = board;
            }
        }

        return resBoard;
    }

//    데이터를 저장하는 함수
    public List<Board> insert(Board board) {

        List<Board> list = sampleBoard.getList();

        list.add(board);

        sampleBoard.setList(list);

        return sampleBoard.getList();
    }

//    데이터를 수정하는 함수
    public List<Board> update(Board board) {

        List<Board> list = sampleBoard.getList();

        if(board.getId() != null) {
            //            수정
            for (Board element : list) {
                if ((int)element.getId() == (int)board.getId()) {
                    element.setId(board.getId());
                    element.setTitle(board.getTitle());
                    element.setContent(board.getContent());
                    element.setUpdateTime(board.getUpdateTime());
                }
            }
        }

        return list;
    }

//  데이터를 삭제하는 함수
    public int deleteById(int id) {
        List<Board> list = sampleBoard.getList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                return 1;
            }
        }

        return 0;
    }
}











