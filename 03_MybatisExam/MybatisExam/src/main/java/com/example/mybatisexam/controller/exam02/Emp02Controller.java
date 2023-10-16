package com.example.mybatisexam.controller.exam02;

import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Emp;
import com.example.mybatisexam.service.exam01.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : com.example.mybatisexam.controller.exam02
 * fileName : Emp02Controller
 * author : L.DH
 * date : 2023-10-16
 * description : CRUD 컨트롤러 : @Restcontroller ( react 용 )
 * 1. 전체 조회
 * 2. 상세 조회
 * 3. 저장 함수
 * 4. 수정 함수
 * 6. 다이나믹 SQL
 * <p>
 * 요약 :
 * todo: 연습 1) 부서 클래스를 참고하여
 *       사원에 전체조회(페이징처리) 와 상세조회 기능을 추가하세요
 *       단, ResponseEntity 사용하세요
 *   Emp02Controller
 *   url : 전체조회 : /emp
 *         상세조회 : /emp/{eno}
 * <p>
 * todo: 연습 2) 부서 클래스를 참고하여
 *    사원에 저장/수정 기능을 추가하세요
 *    단, ResponseEntity 를 사용하세요
 *    Emp02Controller 코딩,
 *    url : 저장 : /emp
 *          수정 : /emp/{eno}
 * <p>
 * todo: 연습3) 부서 클래스를 참고하여 사원에 삭제기능을 추가하세요
 *  url : /emp/deletion/{eno}
 * <p>
 * todo: 연습 4) 부서 클래스를 참고하여 사원에 다이나믹 조회 기능을 추가하세요
 *    sql문 2개 : 1) 다이나믹 조회 2) 다이나믹 카운트 조회
 *   empDao, emp.xml, empService, empController
 *   url : /emp/dynamic
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-16         L.DH         최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/exam02")
public class Emp02Controller {

    @Autowired
    EmpService empService; // TODO : DI 서비스 객체 가져오기

    /**
     * 전체 조회 : like 검색
     */
//  todo: @RequestParam - url?변수=값&변수2=값2 (쿼리스트링 방식)
    @GetMapping("/emp")
    public ResponseEntity<Object> getDeptAll(
            @RequestParam(defaultValue = "") String ename
            , @RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "3") int size
    ) {
        try {
            PageReq pageReq = new PageReq(page, size);

//      todo: 전체 조회 함수 호출
            PageRes<Emp> pageRes
                    = empService.findByEnameContaining(ename, pageReq);

//      todo: jsp 정보전달( 부서배열, 페이징정보 )
//        자료구조 (키, 값) : Map
            Map<String, Object> response = new HashMap<>();

            response.put("emp", pageRes.getContent());              // 사원배열
            response.put("currentPage", pageRes.getNumber());       // 현재 페이지 번호
            response.put("totalItems", pageRes.getTotalElements()); // 전체 테이블 건수
            response.put("totalPages", pageRes.getTotalPages());    // 전체 페이지 개수
            response.put("startPage", pageRes.getStartPage());      // 현재 시작 페이지 번호
            response.put("endPage", pageRes.getEndPage());          // 현재 끝 페이지 번호

            if (pageRes.isEmpty() == false) {
//                todo: 조회 성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                todo: 0건 조회 (실패)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 상세 조회
     */
    @GetMapping("/emp/{eno}")
    public ResponseEntity<Object> getDeptId(@PathVariable int eno) {
        try {
//                todo: 상세조회 함수 호출
            Optional<Emp> optionalEmp
                    = empService.findById(eno);

            if (optionalEmp.isEmpty() == false) {
//                todo: 조회 성공
                return new ResponseEntity<>(optionalEmp.get(), HttpStatus.OK);
            } else {
//                todo: 0건 조회 (실패)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 저장 함수
     */
    @PostMapping("/emp")
    public ResponseEntity<Object> createEmp(
            @RequestBody Emp emp
    ) {
        try {
            int count = empService.save(emp);

            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 수정 함수
     */
    @PutMapping("/emp/{eno}")
    public ResponseEntity<Object> updateEmp(
            @RequestBody Emp emp,
            @PathVariable int eno
    ) {
        try {
            // TODO : 수정함수 (기본키가 있으면)
            int count = empService.save(emp);

            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 삭제함수
     */
    @DeleteMapping("/emp/deletion/{eno}")
    public ResponseEntity<Object> deleteEmp(
            @PathVariable int eno
    ) {
        try {
//                todo: 삭제 함수 호출
            boolean bSuccess = empService.removeById(eno);

            if (bSuccess == true) {
//                todo: 삭제 성공
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//                todo: 0건 삭제 (실패)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * todo dynamic sql 조회
     */
    @GetMapping("/emp/dynamic")
    public ResponseEntity<Object> getEmpDynamic(
            @RequestParam(defaultValue = "") String ename
            , @RequestParam(defaultValue = "") String job
            , @RequestParam(defaultValue = "0") int manager
            , @RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "3") int size

    ) {
        try {
            PageReq pageReq = new PageReq(page, size);

//      todo: dynamic 조회 함수 호출
            PageRes<Emp> pageRes
                    = empService.findByDynamicContaining(ename, job, manager, pageReq);

//      todo: jsp 정보전달( 부서배열, 페이징정보 )
//        자료구조 (키, 값) : Map
            Map<String, Object> response = new HashMap<>();

            response.put("dept", pageRes.getContent()); // 부서배열
            response.put("currentPage", pageRes.getNumber()); // 현재 페이지 번호
            response.put("totalItems", pageRes.getTotalElements()); // 전체 테이블 건수
            response.put("totalPages", pageRes.getTotalPages()); // 전체 페이지 개수

            if (pageRes.isEmpty() == false) {
//                todo: 조회 성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                todo: 0건 조회 (실패)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}