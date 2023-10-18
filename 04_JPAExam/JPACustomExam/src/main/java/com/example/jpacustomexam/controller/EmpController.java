package com.example.jpacustomexam.controller;

import com.example.jpacustomexam.dto.EmpGroupDto;
import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.controller
 * fileName : EmpController
 * author : L.DH
 * date : 2023-10-17
 * description : 사원 컨트롤러
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
@Slf4j
@RestController
public class EmpController {
    @Autowired
    EmpService empService; // DI

    /**
     * 1) 전체 조회 + 정렬(사원번호 내림차순(Desc))
     */
    @GetMapping("/emp/eno/desc")
    public ResponseEntity<Object> getEmpAllDesc() {
        try {
//            전체 조회 + 정렬(eno 내림차순) 호출
            List<Emp> list = empService.findAllByOrderByEnoDesc();
            if (list.isEmpty() == false) {
//             성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//              데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 2) 전체 조회 + 정렬(사원명 내림차순(Desc))
     */
    @GetMapping("/emp/ename/desc")
    public ResponseEntity<Object> findAllByOrderByEnameDesc() {
        try {
//            전체 조회 + 정렬(eno 내림차순) 호출
            List<Emp> list = empService.findAllByOrderByEnameDesc();
            if (list.isEmpty() == false) {
//             성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//              데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 3) 전체조회 + ename like(Containing) 검색 + 정렬(ename 내림차순) 조회
     */
    @GetMapping("/emp/ename/containing/desc/{ename}")
    public ResponseEntity<Object> findAllByEnameContainingOrderByEnameDesc(
            @PathVariable String ename
    ) {
        try {
//            전체 조회 + 정렬(ename 내림차순) 호출
            List<Emp> list
                    = empService
                    .findAllByEnameContainingOrderByEnameDesc(ename);
            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 4) 전체조회 + And 조회
     */
    @GetMapping("/emp/dno/{dno}")
    public ResponseEntity<Object> findAllByEnameContaining(
            @PathVariable int dno
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllByJobAndDno("MANAGER", dno);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 5) 전체조회 + Between 조회
     */
    @GetMapping("/emp/salary/{first}/{last}")
    public ResponseEntity<Object> findAllBySalaryBetween(
            @PathVariable int first,
            @PathVariable int last
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllBySalaryBetween(first, last);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 6) 전체조회 + UPPER 조회
     */
    @GetMapping("/emp/upper/job/{job}")
    public ResponseEntity<Object> findAllByJobIgnoreCase(
            @PathVariable String job
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllByJobIgnoreCase(job);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 7)  전체조회 + IsNotNull 조회
     */
    @GetMapping("/emp/commission")
    public ResponseEntity<Object> findAllByCommissionIsNotNull(
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllByCommissionIsNotNull();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 8)  전체조회 + 다중 정렬(내림차순(Desc)+오름차순(Asc)) 조회
     */
    @GetMapping("/emp/salary/desc/ename/asc")
    public ResponseEntity<Object> findAllByOrderBySalaryDescEnameAsc() {
        try {
//            전체 조회 + 정렬(eno 내림차순) 호출
            List<Emp> list = empService.findAllByOrderBySalaryDescEnameAsc();
            if (list.isEmpty() == false) {
//             성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//              데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            예외 처리
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 9)  전체조회 + OR(LessThan, GreaterThan) 조회
     */
    @GetMapping("/emp/or/salary/{first}/{last}")
    public ResponseEntity<Object> findAllBySalaryLessThanOrSalaryGreaterThan(
            @PathVariable int first,
            @PathVariable int last
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService
                    .findAllBySalaryLessThanOrSalaryGreaterThan(first, last);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 10)  전체조회 + OR 조회
     */
    @GetMapping("/emp/or/commission/{first}/{second}/{third}")
    public ResponseEntity<Object> findAllByCommissionOrCommissionOrCommission(
            @PathVariable int first,
            @PathVariable int second,
            @PathVariable int third
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService
                    .findAllByCommissionOrCommissionOrCommission(first, second, third);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    --------------------------------------------------
//    @Query 예제
//    -------------------------------------------------
    /** 전체조회 + ename like 검색 : @Query */
    @GetMapping("/emp/ename/{ename}")
    public ResponseEntity<Object> selectByEname(
            @PathVariable String ename
    ) {
        try {
//         전체 조회 + 정렬(dno 오름차순) 호출
            List<Emp> list
                    = empService.selectByEname(ename);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 연습 2) : @Query */
    @GetMapping("/emp/desc/asc")
    public ResponseEntity<Object> selectDesc() {
        try {
//         전체 조회 + 정렬(dno 오름차순) 호출
            List<Emp> list
                    = empService.selectDesc();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 연습 3) : @Query */
    @GetMapping("/emp/salary/{salary}")
    public ResponseEntity<Object> selectDesc(
            @PathVariable int salary
    ) {
        try {
//         전체 조회 + 정렬(dno 오름차순) 호출
            List<Emp> list
                    = empService.selectSalary(salary);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 연습 4) : @Query */
    @GetMapping("/emp/hiredate/{first}/{last}")
    public ResponseEntity<Object> selectDesc(
            @PathVariable String  first,
            @PathVariable String last
    ) {
        try {
            List<Emp> list
                    = empService.selectHiredate(first,last);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 연습 5) : @Query(dto) */
    @GetMapping("/emp/group")
    public ResponseEntity<Object> selectGroupDnoJob() {
        try {
            List<EmpGroupDto> list
                    = empService.selectGroupDnoJob();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 연습 6) : @Query(dto) */
    @GetMapping("/emp/dno/group")
    public ResponseEntity<Object> selectGroupDnoTrunc() {
        try {
            List<EmpGroupDto> list
                    = empService.selectGroupDnoTrunc();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 연습 7) : @Query(dto) */
    @GetMapping("/emp/sum/max")
    public ResponseEntity<Object> selectGroupSumMax() {
        try {
            List<EmpGroupDto> list
                    = empService.selectGroupSumMax();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 연습 8) : @Query(dto) */
    @GetMapping("/emp/hiredate/min/max")
    public ResponseEntity<Object> selectGroupHiredate() {
        try {
            List<EmpGroupDto> list
                    = empService.selectGroupHiredate();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


} // end of class
