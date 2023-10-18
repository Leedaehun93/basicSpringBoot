package com.example.jpacustomexam.repository;

import com.example.jpacustomexam.dto.DeptGroupDto;
import com.example.jpacustomexam.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.repository
 * fileName : DeptRepository
 * author : L.DH
 * date : 2023-10-17
 * description : JPA 레포지토리 인터페이스 ( DB 접속 함수들(기본 CRUD 함수 있음)
 * == DAO 비슷함
 * 요약 :
 * 1. JPA 쿼리 메소드 전체 조회 + 정렬(내림차순, 내림차순)
 * 2. JPA 쿼리 메소드 전체 like 조회 + 정렬(내림차순, 내림차순)
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-17         L.DH         최초 생성
 */
// TODO : @Repository - 클래스 위에 붙이고, 스프링서버가 실행될때 자동으로
//      객체 1개를 만들어줌 ( IOC )
//   사용법 : 인터페이스명 extends JpaRepository<모델클래스명, 기본키의자료형>@Repository
@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {
//    JPA : ORM(Object-Relational Mapping) 프레임워크
//    개발자 직접 sql 작성 하는 기능(JPQL) : 1) 쿼리메소드
//                                        2) @Query 쓰는 방법 : 첫글자는 대문자 & 단어사이 대문자
//    쿼리메소드 예) findAllByOrderByDnoDesc : findAll - 전체조회
//                                           OrderBy - 정렬(Order by)
//                                           Dno     - 대상 컬럼명
//                                           Desc    - 내림차순 [Asc]

//    ------------------------------------------------
//    JPA 쿼리 메소드 예제
//    ------------------------------------------------

    /**
     * 1) 전체 조회 + 정렬(부서번호 내림차순(Desc))
     */
    List<Dept> findAllByOrderByDnoDesc();

    /**
     * 2) 전체 조회 + 정렬(부서명 내림차순(Desc))
     */
    List<Dept> findAllByOrderByDnameDesc();

    /**
     * 3) 전체 조회 + 정렬(부서번호 오름차순(ASC 생략가능))
     */
    List<Dept> findAllByOrderByDno();

    /**
     * 4) 전체 조회 + dname like 검색(DnameContaining) + dname 내림차순 조회
     */
    List<Dept> findAllByDnameContainingOrderByDnameDesc(String dname);

//    ---------------------------------------
//    @Query 예제 : 1) 오라클 쿼리 2) 객체 쿼리
//    ---------------------------------------

//  todo: 1) dname like 검색 : 추천 ( 오라클 쿼리 )
    @Query(value = "SELECT TD.* FROM TB_DEPT TD WHERE TD.DNAME LIKE '%' || :dname || '%' ", nativeQuery = true)
    List<Dept> selectByDname(@Param("dname") String dname);

//  todo: 1-1) 위의 꺼 다르게 코딩 : 참고
//    @Query(value = "SELECT TD.* FROM TB_DEPT TD WHERE TD.DNAME LIKE '%' || :dname || '%' ", nativeQuery = true)
//    List<Dept> selectByDname(String dname);
//  todo: 1-2) 위의 꺼 다르게 코딩 : 참고
//    @Query(value = "SELECT TD.* FROM TB_DEPT TD WHERE TD.DNAME LIKE '%' || ?1 || '%' ", nativeQuery = true)
//    List<Dept> selectByDname(String dname);

//  todo: 2) dname like 검색 : 추천 ( 객체 쿼리 )
//    객체쿼리 만드는 방법 : 테이블 -> 클래스명
//                        컬럼명 -> 속성명
//                        * -> 사용하지 않음 , 클래스명의 별칭을 붙여서 사용
//                        (대소문자를 구분, nativeQuery=true(생략))
//    @Query(value = "SELECT TD FROM Dept TD WHERE TD.dname LIKE '%' || :dname || '%' ")
//    List<Dept> selectByDname(@Param("dname") String dname);

//    todo: 3) 부서 테이블에서 부서명(dname) 과 위치(loc)를 매개변수로 받아
//       조회하는 함수를 작성하려고 한다.
//       단,  nativeQuery = true 사용하세요
//
    @Query(value = "SELECT D.* FROM TB_DEPT D " +
            "WHERE D.DNAME = :dname " +
            "AND   D.LOC   = :loc "
            , nativeQuery = true)
    List<Dept> selectByDnameAndLoc(@Param("dname") String dname,
                                   @Param("loc") String loc);

    //  todo: 4) 부서테이블의 부서번호를 sum, avg, max, min 값을
//       출력하는 함수를 작성하세요.
//      단,  nativeQuery = true 사용하세요
//      , DeptGroupDto 클래스에 저장하세요(오라클 쿼리 : 인터페이스로 만듬)
    @Query(value = "SELECT SUM(D.DNO) AS sumVar " +
            "     , AVG(D.DNO) AS avgVar " +
            "     , MAX(D.DNO) AS maxVar  " +
            "     , MIN(D.DNO) AS minVar  " +
            "FROM TB_DEPT D",
            nativeQuery = true)
    List<DeptGroupDto> selectByGroupFunc();

    //    todo: 5) SQL 기본 내장 함수를 사용하는 함수를 작성하세요.
//      단,  nativeQuery = true 사용하세요
    @Query(value = "SELECT UPPER(D.DNAME) AS upperDname " +
            "     , LOWER(D.DNAME) AS lowerDname " +
            "     , Trim(' Oracle ') As trimOracle " +
            "     , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS charSysdate " +
            "FROM TB_DEPT D",
            nativeQuery = true)
    List<DeptGroupDto> selectByBasicFunc();

    //    todo: 6) case when 사용 쿼리
//     dno < 20 연말 보너스 100%
//     dno > 20   연말 보너스 200%
//     모두 아니면 연말 보너스 없음 이라고 출력하세요
    @Query(value = "SELECT D.DNO, " +
            "       CASE WHEN D.DNO <20 THEN '연말 보너스 100%' " +
            "            WHEN D.DNO >20 THEN '연말 보너스 200%' " +
            "            ELSE '연말 보너스 없음' " +
            "        END AS incentive " +
            "FROM TB_DEPT D ",
            nativeQuery = true)
    List<DeptGroupDto> selectByCase();


} // end of interface