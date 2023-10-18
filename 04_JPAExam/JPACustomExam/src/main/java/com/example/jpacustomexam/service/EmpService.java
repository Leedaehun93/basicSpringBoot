package com.example.jpacustomexam.service;

import com.example.jpacustomexam.dto.EmpGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.service
 * fileName : EmpService
 * author : L.DH
 * date : 2023-10-17
 * description : 사원 서비스
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
 *  힌트: Or 조건 사용
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-17         L.DH         최초 생성
 */
@Service
public class EmpService {

    @Autowired
    EmpRepository empRepository; // DI

    /**
     * 1) 전체 조회 + 정렬(사원번호 내림차순(Desc))
     */
    public List<Emp> findAllByOrderByEnoDesc() {
        List<Emp> list = empRepository.findAllByOrderByEnoDesc();

        return list;
    }

    /**
     * 2) 전체 조회 + 정렬(사원명 내림차순(Desc))
     */
    public List<Emp> findAllByOrderByEnameDesc() {
        List<Emp> list = empRepository.findAllByOrderByEnameDesc();

        return list;
    }

    /**
     * 3) 전체조회 + ename like(Containing) 검색 + 정렬(ename 내림차순) 조회
     */
    public List<Emp> findAllByEnameContainingOrderByEnameDesc(String ename) {
        List<Emp> list = empRepository.findAllByEnameContainingOrderByEnameDesc(ename);

        return list;
    }

    /**
     * 4) 전체조회 + And 조회
     */
    public List<Emp> findAllByJobAndDno(String job, int dno) {
        List<Emp> list = empRepository.findAllByJobAndDno(job, dno);

        return list;
    }

    /**
     * 5) 전체조회 + Between 조회
     */
    public List<Emp> findAllBySalaryBetween(int first, int last) {
        List<Emp> list = empRepository.findAllBySalaryBetween(first, last);

        return list;
    }

    /**
     * 6) 전체조회 + UPPER 조회
     */
    public List<Emp> findAllByJobIgnoreCase(String job) {
        List<Emp> list = empRepository.findAllByJobIgnoreCase(job);

        return list;
    }

    /**
     * 7)  전체조회 + IsNotNull 조회
     */
    public List<Emp> findAllByCommissionIsNotNull() {
        List<Emp> list = empRepository.findAllByCommissionIsNotNull();

        return list;
    }

    /**
     * 8)  전체조회 + 다중 정렬(내림차순(Desc)+오름차순(Asc)) 조회
     */
    public List<Emp> findAllByOrderBySalaryDescEnameAsc() {
        List<Emp> list = empRepository.findAllByOrderBySalaryDescEnameAsc();

        return list;
    }

    /**
     * 9)  전체조회 + OR(LessThan, GreaterThan) 조회
     */
    public List<Emp> findAllBySalaryLessThanOrSalaryGreaterThan(int first, int last) {
        List<Emp> list = empRepository.findAllBySalaryLessThanOrSalaryGreaterThan(first, last);

        return list;
    }

    /**
     * 10)  전체조회 + OR 조회
     */
    public List<Emp> findAllByCommissionOrCommissionOrCommission(int first, int second, int third) {
        List<Emp> list = empRepository.findAllByCommissionOrCommissionOrCommission(first, second, third);

        return list;
    }

//    -------------------------------------------------
//    @Query 예제
//    -------------------------------------------------

    /**
     * 전체조회 + dname like 검색 : @Query
     */
    public List<Emp> selectByEname(String ename) {
        List<Emp> list
                = empRepository.selectByEname(ename);

        return list;
    }

    /**
     * 연습 2) : @Query
     */
    public List<Emp> selectDesc() {
        List<Emp> list
                = empRepository.selectDesc();

        return list;
    }

    /**
     * 연습 3) : @Query
     */
    public List<Emp> selectSalary(int salary) {
        List<Emp> list
                = empRepository.selectSalary(salary);

        return list;
    }

    /**
     * 연습 4) : @Query
     */
    public List<Emp> selectHiredate(String first, String last) {
        List<Emp> list
                = empRepository.selectHiredate(first, last);

        return list;
    }

    /**
     * 연습 5) : @Query(dto)
     */
    public List<EmpGroupDto> selectGroupDnoJob() {
        List<EmpGroupDto> list
                = empRepository.selectGroupDnoJob();

        return list;
    }

    /**
     * 연습 6) : @Query(dto)
     */
    public List<EmpGroupDto> selectGroupDnoTrunc() {
        List<EmpGroupDto> list
                = empRepository.selectGroupDnoTrunc();

        return list;
    }

    /**
     * 연습 7) : @Query(dto)
     */
    public List<EmpGroupDto> selectGroupSumMax() {
        List<EmpGroupDto> list
                = empRepository.selectGroupSumMax();

        return list;
    }

    /** 연습 8) : @Query(dto) */
    public List<EmpGroupDto> selectGroupHiredate() {
        List<EmpGroupDto> list
                = empRepository.selectGroupHiredate();

        return list;
    }


} // end of class
