package com.example.mybatisexam.model.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName : com.example.mybatisexam.model.common
 * fileName : BaseTimeEntity
 * author : L.DH
 * date : 2023-10-12
 * description : 공통 클래스(생성일시, 수정일시)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */
@Getter
@Setter
@ToString
public class BaseTimeEntity {
    /** 등록일 */
    public String insertTime;

    /** 수정일 */
    public String updateTime;

    /** 기본 생성자 */
    public BaseTimeEntity() {
//      TODO : 생성시 현재 날짜 넣기 : yyyy-MM-dd HH:mm:ss
        this.insertTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.updateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

} // end of class
