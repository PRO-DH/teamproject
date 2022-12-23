package com.ibatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 이 인터페이스의 의존성을 마이바티스에게 위임
public interface TestRepository {


    // 데이터 저장 기능
    // 저장/수정/삭제는 성공,실패 두개만 출력하면 되어서 boolean으로 출력.
    // ()안에 여러 변수를 넣으면 일일히 어노테이션을 해줘야해서 TestEntity라는 객체에 여러 변수를 저장해서 한번에 불러온다
    boolean save(TestEntity entity);


    // 데이터 수정 기능
    boolean modify(TestEntity entity);

    // 데이터 삭제 기능
    boolean remove(String id);


    // 데이터 전체 조회 기능
    List<TestEntity> findAll();
}
