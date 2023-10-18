package com.example.jpaexam.controller.exam01;

import com.example.jpaexam.model.Dept;
import com.example.jpaexam.model.Emp;
import com.example.jpaexam.service.DeptService;
import com.example.jpaexam.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam01
 * fileName : EmpController
 * author : L.DH
 * date : 2023-10-16
 * description : 회원 컨트롤러 : (@RestController)
 * 요약 : JPA를 이용한 기본 CRUD
 * 1. Repository 전체 조회
 * 2. Repository 상세 조회
 * 3. Repository 저장 함수
 * 4. Repository 수정 함수
 * 5. Repository 삭제 함수
 *
 * todo: 연습1) 부서 클래스를 참고하여 사원 모델을(Emp) 만들고,
 *   empRepository, empService, empController 를 작성하세요
 *   전체 조회 함수 만드세요
 *   (시퀀스명 : SQ_EMP,
 *    시퀀스함수명 : SQ_EMP_GENERATOR )
 *   url : /emp
 * <p>
 * todo: 연습 2) 부서 클래스를 참고하여 상세조회, 저장/수정 기능을 사원 모델에 추가하세요
 *   상세조회 url : /emp/{eno}
 *     저장  url : /emp
 *     수정  url : /emp/edit/{eno}
 *
 * todo: 연습 3) 부서 클래스를 참고하여 사원 모델에 삭제 기능을 추가하세요
 *   url : /emp/delete/{eno}
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-16         L.DH         최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/exam01")
public class EmpController {

    @Autowired
    EmpService empService; // 객체 가져오기 (DI)

    /**
     * 전체 조회
     */
    @GetMapping("/emp")
    public ResponseEntity<Object> getDeptAll() {
        try {
//          todo: 전체 조회 함수 호출
            List<Emp> list = empService.findAll();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 상세 조회
     */
    @GetMapping("/emp/{eno}")
    public ResponseEntity<Object> getEmpId(
            @PathVariable int eno
    ) {
        try {
//          TODO : 전체 조회 함수 호출
            Optional<Emp> optionalEmp = empService.findById(eno);

            if (optionalEmp.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(optionalEmp.get(), HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
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
//            jap 서비스 저장 함수 호출 : dept2(DB 저장된 객체)
            Emp emp2 = empService.save(emp);
            return new ResponseEntity<>(emp2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 수정 함수
     */
    @PutMapping("/emp/edit/{eno}")
    public ResponseEntity<Object> updateEmp(
            @RequestBody Emp emp,
            @PathVariable int eno
    ) {
        try {
//            jap 서비스 저장 함수 호출 : dept2(DB 저장된 객체)
            Emp emp2 = empService.save(emp);
            return new ResponseEntity<>(emp2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 삭제 함수 */
    @DeleteMapping("/emp/delete/{eno}")
    public ResponseEntity<Object> deleteEmp(
            @PathVariable int eno
    ) {
        try {
//          todo: 삭제 함수 호출
            boolean bSuccess = empService.removeById(eno);

            if (bSuccess == true) {
//                성공
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//                0건 삭제
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

} // end of class
