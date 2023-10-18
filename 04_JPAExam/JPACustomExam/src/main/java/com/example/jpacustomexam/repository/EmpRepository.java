package com.example.jpacustomexam.repository;

import com.example.jpacustomexam.dto.EmpGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.repository
 * fileName : EmpRepository
 * author : L.DH
 * date : 2023-10-17
 * description : JPA 레포지토리 인터페이스 ( DB 접속 함수들(기본 CRUD 함수 있음)
 * == DAO 비슷함
 * 요약 : JPQL @Query 쿼리 메소드 쓰는 방법
 * JPA 쿼리 메소드 연습 문제
 * <p>
 * todo: 연습 1) 전체 조회 + 정렬(eno 내림차순)
 * todo: 연습 2) 전체 조회 + (ename 오름차순)
 * todo: 연습 3) ename like 검색
 * <p>
 * todo: 응용 연습문제 : 구글링 (JPA 쿼리메소드)
 * todo: 연습 4) EMP 테이블에서 Job 이 manager 이고
 *           매개변수로 부서번호(dno)를 받는 함수를 작성하세요.
 * <p>
 * todo: 연습 5) Emp 테이블에서 salary 가 1000 ~ 1500 사이의 값을 같는
 *  사원을 조회하려고 합니다.  함수를 작성해 주세요
 * <p>
 *  todo: 6) Emp 테이블에서 Job 이 manager 인 사원의 정보를
 *      출력하는 함수를 작성하세요.
 *    단, Job 의 매개변수는 소문자 또는 대문자가 들어올 수 있음
 *      where job = UPPER('manager')
 *   힌트 : 컬럼명 IgnoreCase
 * <p>
 * todo: 7) commission 을 받는 사원을 모두 출력하는 함수를 작성하세요.
 *  힌트 : where commission is not null
 * <p>
 * todo: 8) salary desc, ename asc 로 정렬하는 함수를 작성하세요.
 * 힌트 : 컬럼1Desc컬럼2Asc
 * <p>
 * todo: 9) salary < 1000 또는 salary > 1500 사이에
 *      해당하는 사원을 출력하는 함수를 작성하세요.
 *  힌트 : < - LessThan , > - GreaterThan
 * <p>
 * todo: 10) commission 이 300 이거나 500
 *      또는 1500 인 사원을 출력하는 함수를 작성하세요.
 *    힌트: Or 조건 사용
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-17         L.DH         최초 생성
 */
// TODO : @Repository - 클래스 위에 붙이고, 스프링서버가 실행될때 자동으로
//      객체 1개를 만들어줌 ( IOC )
//   사용법 : 인터페이스명 extends JpaRepository<모델클래스명, 기본키의자료형>@Repository
@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
//    ------------------------------------------------
//    JPA 쿼리 메소드 예제
//    ------------------------------------------------
    /**
     * 1) 전체 조회 + 정렬(사원번호 내림차순(Desc))
     */
    List<Emp> findAllByOrderByEnoDesc();

    /**
     * 2) 전체 조회 + 정렬(사원명 내림차순(Desc))
     */
    List<Emp> findAllByOrderByEnameDesc();

    /**
     * 3) 전체조회 + ename like(Containing) 검색 + 정렬(ename 내림차순) 조회
     */
    List<Emp> findAllByEnameContainingOrderByEnameDesc(String ename);

    /**
     * 4) 전체조회 + And 조회
     */
    List<Emp> findAllByJobAndDno(String job, int dno);

    /**
     * 5)  전체조회 + Between 조회
     */
    List<Emp> findAllBySalaryBetween(int first, int last);

    /**
     * 6)  전체조회 + UPPER 조회
     */
    List<Emp> findAllByJobIgnoreCase(String job);

    /**
     * 7)  전체조회 + IsNotNull 조회
     */
    List<Emp> findAllByCommissionIsNotNull();

    /**
     * 8)  전체조회 + 다중 정렬(내림차순(Desc)+오름차순(Asc)) 조회
     */
    List<Emp> findAllByOrderBySalaryDescEnameAsc();

    /**
     * 9)  전체조회 + OR(LessThan, GreaterThan) 조회
     */
    List<Emp> findAllBySalaryLessThanOrSalaryGreaterThan(int first, int last);

    /**
     * 10)  전체조회 + OR 조회
     */
    List<Emp> findAllByCommissionOrCommissionOrCommission(int first, int second, int third);

//    ---------------------------------------
//    @Query 예제 : 1) 오라클 쿼리 2) 객체 쿼리
//    ---------------------------------------

//  todo: 1) ename like 검색 (단, % 1개만 사용 )
@Query(value = "SELECT TD.* FROM TB_EMP TD WHERE TD.ENAME LIKE '%' || :ename || '%' "
        , nativeQuery = true)
List<Emp> selectByEname(@Param("ename") String ename);

//  todo: 2) salary 내림차순, ename 오름차순으로 정렬
//    nativeQuery = true 사용
    @Query(value = "SELECT D.* FROM TB_EMP D " +
            "ORDER BY D.SALARY DESC, D.ENAME ASC "
            , nativeQuery = true)
    List<Emp> selectDesc();

//  todo: 3) commission 이 null 이고
//         salary 매개변수로 전달되는 값보다 같거나 큰 사원 정보를 모두 출력하세요.
//    nativeQuery = true 사용
    @Query(value = "SELECT * FROM TB_EMP " +
            "WHERE COMMISSION IS NULL " +
            "AND SALARY >= :salary "
            , nativeQuery = true)
    List<Emp> selectSalary(@Param("salary") int salary);

//  todo: 4) 1982년도에 입사한 사원 출력하기, 입사일 내림차순하세요
//    nativeQuery = true 사용
    @Query(value = "SELECT * FROM TB_EMP " +
            "WHERE HIREDATE BETWEEN :first AND :last "
            , nativeQuery = true)
    List<Emp> selectHiredate(@Param("first") String first,
                             @Param("last") String last);

//    todo: 5) dno, job 별 월급여의 합을 출력하는 함수를 작성하세요.(tb_emp)
//      nativeQuery = true 사용,
//      dto : EmpGroupDto
    @Query(value = "SELECT dno, job, SUM(SALARY) AS salary " +
            "FROM TB_EMP " +
            "GROUP BY DNO, JOB "
            , nativeQuery = true)
    List<EmpGroupDto> selectGroupDnoJob();

//    todo: 6) dno 별 월급여의 평균을 출력하는 함수를 작성하세요.
//       단, 소수점 절삭(버림, trunc) 하세요
//       nativeQuery = true 사용,
//       dto : EmpGroupDto
    @Query(value = "SELECT DNO, TRUNC(AVG(SALARY)) AS avgSalary " +
            "FROM TB_EMP " +
            "GROUP BY DNO "
            , nativeQuery = true)
    List<EmpGroupDto> selectGroupDnoTrunc();

//    todo: 7) 사원의 수와(COUNT) 최고월급(SALARY)을(MAX) 출력하세요.
//       nativeQuery = true 사용,
//       dto : EmpGroupDto
    @Query(value = "SELECT COUNT(ENO) AS countEno, " +
            "MAX(SALARY) AS sumSalary " +
            "FROM TB_EMP "
            , nativeQuery = true)
    List<EmpGroupDto> selectGroupSumMax();

//    todo: 8) 사원 테이블에서 가장 오래된 입사일(HIREDATE)과(MAX)
//            가장 빠른 입사일을(MIN) 출력하세요.
//       nativeQuery = true 사용,
//       dto : EmpGroupDto
    @Query(value = "SELECT MAX(HIREDATE) AS maxHiredate, " +
            "       MIN(HIREDATE) AS minHiredate " +
            "FROM TB_EMP "
            , nativeQuery = true)
    List<EmpGroupDto> selectGroupHiredate();


} // end of interface