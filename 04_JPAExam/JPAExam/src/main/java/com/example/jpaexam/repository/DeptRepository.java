package com.example.jpaexam.repository;

import com.example.jpaexam.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : DeptRepository
 * author : L.DH
 * date : 2023-10-16
 * description : JPA 레포지토리 인터페이스 ( DB 접속 함수들(CRUD) 있음)
 *  *               == DAO 비슷함
 * 요약 : JPA를 이용한 기본 CRUD
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-16         L.DH         최초 생성
 */
// TODO : @Repository - 클래스 위에 붙이고, 스프링서버가 실행될때 자동으로
//      객체 1개를 만들어줌 ( IOC )
//   사용법 : 인터페이스명 extends JpaRepository<모델클래스명, 기본키의자료형>@Repository
@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {
}