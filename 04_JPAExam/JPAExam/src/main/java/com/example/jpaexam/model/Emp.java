package com.example.jpaexam.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * packageName : com.example.jpaexam.model
 * fileName : Emp
 * author : L.DH
 * date : 2023-10-16
 * description : 사원 모델 클래스( 엔티티(entity) )
 * 요약 :
 *
 * todo: 연습1) 부서 클래스를 참고하여 사원 모델을(Emp) 만들고,
 *   empRepository, empService, empController 를 작성하세요
 *   전체 조회 함수 만드세요
 *   (시퀀스명 : SQ_EMP,
 *    시퀀스함수명 : SQ_EMP_GENERATOR )
 *   url : /emp
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-16         L.DH         최초 생성
 */
@Entity
@Table(name = "TB_EMP")
@SequenceGenerator(
        name = "SQ_EMP_GENERATOR"
        , sequenceName = "SQ_EMP"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate

public class Emp extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_EMP_GENERATOR"
    )
    @Column(columnDefinition = "NUMBER")
    private Integer eno;    // 사원번호(기본키, 시퀀스 사용)

    @Column(columnDefinition = "VARCHAR2(225)")
    private String ename;   // 사원명

    @Column(columnDefinition = "VARCHAR2(225)")
    private String job;   // 직업

    @Column(columnDefinition = "NUMBER")
    private Integer manager;    // 매니저


    @Column(columnDefinition = "VARCHAR2(225)")
    private String hiredate;   // 입사일

    @Column(columnDefinition = "NUMBER")
    private Integer salary;    // 상여금

    @Column(columnDefinition = "NUMBER")
    private Integer commission;    // 급여

    @Column(columnDefinition = "NUMBER")
    private Integer dno;    // 부서번호


}
