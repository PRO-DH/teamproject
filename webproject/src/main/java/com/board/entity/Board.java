package com.board.entity;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter @Getter @ToString
@AllArgsConstructor
public class Board {

    private String id;
    private String userId;
    private String title;
    private boolean done;
    private Date regDate;



    private static long seq;

    public Board() {
        this.id = UUID.randomUUID().toString();
    }

    public Board(String title) {
        this();
        this.title = title;
        this.userId = "noname";
    }
}
