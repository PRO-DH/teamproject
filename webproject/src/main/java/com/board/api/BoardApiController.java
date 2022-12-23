package com.board.api;

import com.board.dto.BoardDTO;
import com.board.dto.FindAllDTO;
import com.board.entity.Board;
import com.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/board")
@RequiredArgsConstructor
@CrossOrigin
public class BoardApiController {

    private final BoardService service;

    // 게시글 전체 조회
    @GetMapping
    public ResponseEntity<?> todos(@AuthenticationPrincipal String userId) {
        log.info("/api/board GET request!");
        return ResponseEntity.ok().body(service.findAllServ(userId));
    }



    // 게시글 등록(제목)
    @PostMapping
    public ResponseEntity<?> create(
            @AuthenticationPrincipal String userId
            ,@RequestBody Board newBoard) {

        newBoard.setUserId(userId);
        log.info("/api/board POST request! - {}", newBoard);

        try {
            FindAllDTO dto = service.createServ(newBoard);

            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    // 게시글 개별 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable String id) {
        log.info("/api/board/{} GET request!", id);

        if (id == null) return ResponseEntity.badRequest().build();

        BoardDTO dto = service.findOneServ(id);

        if (dto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(dto);
    }


    // 글 삭제 요청
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id, @AuthenticationPrincipal String userId) {

        log.info("/api/board/{} DELETE request!", id);

        try {
            FindAllDTO dtos = service.deleteServ(id, userId);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    // 글 수정 요청
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Board board, @AuthenticationPrincipal String userId) {

        board.setUserId(userId);
        log.info("/api/board PUT request! - {}", board);

        try {
            FindAllDTO dtos = service.update(board);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
