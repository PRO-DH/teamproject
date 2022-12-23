package com.rest;

import lombok.*;

@Setter @Getter
@ToString
public class Person {

    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
