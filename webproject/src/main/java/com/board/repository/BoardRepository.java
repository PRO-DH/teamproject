package com.board.repository;

import com.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {

    // 글 생성 기능
    boolean save(Board board);

    // 게시판 목록조회 기능
    List<Board> findAll(String userId);

    // 글 개별조회 기능
    Board findOne(String id);

    // 글 삭제 기능
    boolean remove(String id);

    // 글 수정 기능 (체크기능, 제목수정기능)
    boolean modify(Board board);

}
