package com.ibatis;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter @Getter @ToString @AllArgsConstructor
public class TestEntity {
    private String id;
    private String username;
    private int age;

    public TestEntity(){
        this.id = UUID.randomUUID().toString(); //중복없는 기다란 문자를 가져온다.
    }
}
