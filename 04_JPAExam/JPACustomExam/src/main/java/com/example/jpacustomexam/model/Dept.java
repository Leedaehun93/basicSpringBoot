package com.example.jpacustomexam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.example.modelexam.model
 * fileName : Dept
 * author : kangtaegyung
 * date : 2022/10/12
 * description : 부서 모델 클래스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/12         kangtaegyung          최초 생성
 */
@Entity
@Table(name="TB_DEPT")
@SequenceGenerator(
        name = "SQ_DEPT_GENERATOR"
        , sequenceName = "SQ_DEPT"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
//@ToString(exclude = "emp")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Dept extends BaseTimeEntity {
    //    부서넘버
//    @Id : Primary Key 에 해당
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_DEPT_GENERATOR"
    )
    @Column(columnDefinition="NUMBER")
    private Integer dno;
    //    부서이름
    @Column(columnDefinition="VARCHAR2(255)")
    private String dname;
    //    부서위치
    @Column(columnDefinition="VARCHAR2(255)")
    private String loc;
}





















