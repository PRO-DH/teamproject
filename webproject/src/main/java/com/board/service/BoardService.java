package com.board.service;


import com.board.dto.BoardDTO;
import com.board.dto.FindAllDTO;
import com.board.entity.Board;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// 역할: 컨트롤러와 저장소 사이의 잡일 처리 역할
@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    /*
         - 할 일 목록조회 중간처리
         1. 컨트롤러에게 userId를 뺀 할일 리스트를 전달한다.
         2. 할일 목록의 카운트를 세서 따로 추가해서 전달한다.
     */
    public FindAllDTO findAllServ(String userId) {
        return new FindAllDTO(repository.findAll(userId));
    }

    public FindAllDTO createServ(final Board newBoard) {

        if (newBoard == null) {
            log.warn("newBoard cannot be null!");
            throw new RuntimeException("newBoard cannot be null!");
        }

        boolean flag = repository.save(newBoard);
        if (flag) log.info("새로운 글 [Id: {}]이 저장되었습니다.", newBoard.getId());

        return flag ? findAllServ(newBoard.getUserId()) : null;
    }

    public FindAllDTO deleteServ(String id, String userId) {

        int x = 10, y = 20;

        boolean flag = repository.remove(id);

        // 삭제 실패한 경우
        if (!flag) {
            log.warn("delete fail!! not found id [{}]", id);
            throw new RuntimeException("delete fail!");
        }
        return findAllServ(userId);
    }



    public Board findOneServ(String id) {

        Board board = repository.findOne(id);
        log.info("findOneServ return data - {}", board);


        return board != null ? new BoardDTO(board) : null;
    }

    public FindAllDTO update(Board board) {

        boolean flag = repository.modify(board);
        return flag ? findAllServ(board.getUserId()) : new FindAllDTO();
    }

}
