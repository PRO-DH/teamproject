package com.board.dto;

import com.board.entity.Board;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {

    private int count; // 할 일 목록의 개수
    private List<BoardDTO> todos; // userId가 빠진 할일 목록

    public FindAllDTO(List<Board> boardList) {
        this.count = boardList.size();
        this.convertDtoList(boardList);
    }


    public void convertDtoList(List<Board> toDoList) {
        List<BoardDTO> dtos = new ArrayList<>();

        for (Board board : toDoList) {
            dtos.add(new BoardDTO(board));
        }
        this.todos = dtos;
    }
}
