package com.example.modelexam.controller.quiz;

import com.example.modelexam.model.Board;
import com.example.modelexam.service.quiz.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * packageName : com.example.modelexam.controller.quiz
 * fileName : BoardController
 * author : L.DH
 * date : 2023-10-12
 * description : @RestController 종합문제
 * 요약 : react 연동(vue 등) CRUD 에 해당하는 서비스 함수
 * todo: 종합문제 1) 부서 업무 클래스들을 참고하여
 *    BoardService 클래스를 만들어서 CRUD 에 해당하는 서비스 함수를 정의하세요
 *    BoardController 클래스를 만들어서 CRUD 에 해당하는 컨틀롤러 함수를 정의하세요
 *    단, @RestController 를 사용하고,
 *       예외처리와 ResponseEntity 를 사용해 데이터와 메세지를 같이 전송하세요
 *    url : board 이용 (기본키 : id)
 *    객체 : Board (model 폴더)
 *    DB함수 : BoardDao (dao 폴더)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */

@Slf4j
@RestController
@RequestMapping("/quiz")
public class BoardController {

// todo: 종합문제 1) 부서 업무 클래스들을 참고하여
//    BoardService 클래스를 만들어서 CRUD 에 해당하는 서비스 함수를 정의하세요
//    BoardController 클래스를 만들어서 CRUD 에 해당하는 컨틀롤러 함수를 정의하세요
//    단, @RestController 를 사용하고,
//       예외처리와 ResponseEntity 를 사용해 데이터와 메세지를 같이 전송하세요
//    url : board 이용 (기본키 : id)
//    객체 : Board (model 폴더)
//    DB함수 : BoardDao (dao 폴더)

    @Autowired
    BoardService boardService;

    /**
     * 전체 조회
     *
     * @return
     */
    @GetMapping("/board")
    public ResponseEntity<Object> getBoardAll() {
        try {
            List<Board> list = boardService.findAll();
            if (list.isEmpty() == false) {
//              todo: 조회 성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//              todo: 데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//          todo: INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 상세 조회
     */
    @GetMapping("/board/{id}")
    public ResponseEntity<Object> getBoardId(
            @PathVariable int id
    ) {
        try {
            Optional<Board> optionalBoard = boardService.findById(id);
            if (optionalBoard.isEmpty() == false) {
//              todo: 조회 성공
                return new ResponseEntity<>(optionalBoard.get(), HttpStatus.OK);
            } else {
//              todo: 데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//          todo: INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 저장 함수
     */
    @PostMapping("/board")
    public ResponseEntity<Object> createBoard(
            @RequestBody Board board) {
        try {
            List<Board> list = boardService.save(board);
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            log.debug(e.getMessage());
//          todo: INTERNAL_SERVER_ERROR(500) : sql 구문 에러 등
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 수정 함수
     */
    @PutMapping("/board/edit/{id}")
    public ResponseEntity<Object> updateBoard(
            @PathVariable int id,
            @RequestBody Board board
    ) {
        try {
            List<Board> list = boardService.save(board);
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 삭제 함수
     */
    @DeleteMapping("/board/delete/{id}")
    public ResponseEntity<Object> deleteDept(
            @PathVariable int id
    ) {
        try {
            boolean bSuccess = boardService.removeById(id);
            if (bSuccess == true) {
//              todo: 삭제 성공
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//              todo: 0건 삭제 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//          todo: INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}