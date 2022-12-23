package com.board.dto;

import com.board.entity.Board;
import lombok.*;

import java.util.Date;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private String id;
    private String title;
    private boolean done;
    private Date regDate;

    public BoardDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.done = board.isDone();
        this.regDate = board.getRegDate();
    }
}
