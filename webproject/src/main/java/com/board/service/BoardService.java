package com.board.service;


import com.board.dto.BoardDTO;
import com.board.dto.FindAllDTO;
import com.board.entity.Board;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;


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
