package com.example.modelexam.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName : com.example.simpledms.model
 * fileName : BaseTimeEntiry
 * author : kangtaegyung
 * date : 2023/07/13
 * description : 공통 클래스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/07/13         kangtaegyung          최초 생성
 */
@Getter
@Setter
@ToString
public class BaseTimeEntity {

    /** 등록일 */
    private String insertTime;

    /** 수정일 */
    private String updateTime;

    //    초기값 저장
    public BaseTimeEntity() {
        this.insertTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));;
        this.updateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));;
    }
}
