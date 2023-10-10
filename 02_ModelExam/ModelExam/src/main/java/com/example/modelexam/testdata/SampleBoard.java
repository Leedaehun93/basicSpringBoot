package com.example.modelexam.testdata;

import com.example.modelexam.model.Board;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.example.modelexam.testdata
 * fileName : SampleMember
 * author : kangtaegyung
 * date : 2022/10/14
 * description : 샘플 회원 데이터 클래스(DB 테이블 대체)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/14         kangtaegyung          최초 생성
 */
@Component
@Getter
@Setter
public class SampleBoard {
    List<Board> list = new ArrayList<>();

    public SampleBoard() {

        int iCount = 1;

        Board board = Board.builder()
                .id(iCount)
                .title("제목")
                .content("내용")
                .build();

        list.add(board);

        board = Board.builder()
                .id(++iCount)
                .title("제목2")
                .content("내용2")
                .build();

        list.add(board);

        board = Board.builder()
                .id(++iCount)
                .title("제목3")
                .content("내용3")
                .build();

        list.add(board);

        board = Board.builder()
                .id(++iCount)
                .title("제목4")
                .content("내용4")
                .build();

        list.add(board);

        board = Board.builder()
                .id(++iCount)
                .title("제목5")
                .content("내용5")
                .build();

        list.add(board);
    }
}
