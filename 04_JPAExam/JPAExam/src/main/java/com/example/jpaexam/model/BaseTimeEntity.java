package com.example.jpaexam.model;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName : com.example.jpaexam.model
 * fileName : BaseTimeEntity
 * author : L.DH
 * date : 2023-10-16
 * description : JPA 에서 자동으로 생성일자/수정일자를 만들어 주는 클래스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-16         L.DH         최초 생성
 */
@Getter
// TODO : 자동으로 생성일자/수정일자 컬럼을 sql 문에 추가 시키는 어노테이션 2개
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    // TODO 공통 속성 : yyyy-MM-dd HH:mm:ss 아니고 기본 패턴으로 보이므로 공통 속성을 패턴으로 저장해줌
    private String insertTime;

    private String updateTime;

    // TODO : 해당 테이블에 데이터가 만들어 질 때 실행되는 이벤트 함수
    @PrePersist
    void onPrePersist() {
        this.insertTime
                = LocalDateTime.now()
                .format(DateTimeFormatter
                        .ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // TODO : 해당 테이블에 데이터가 수정될 때 (update 문) 실행되는 이벤트 함수
    @PostUpdate
    void OnPreUpdate() {
        this.updateTime
                = LocalDateTime.now()
                .format(DateTimeFormatter
                        .ofPattern("yyyy-MM-dd HH:mm:ss"));

        this.insertTime = this.updateTime;  // TODO : 생성일시 == 수정일시 동일하게 처리
    }

}
