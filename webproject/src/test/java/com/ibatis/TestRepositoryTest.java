//package com.example.demo.ibatis;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//class TestRepositoryTest {
//
//    @Autowired
//    TestRepository repository;
//
//    @Test
//    @DisplayName("유저이름과 나이가 TBL_TEST 테이블에 저장되어야 한다.")
//        // 단언. 강력하게 주장한다.
//    void saveTest() {
//        //given : 테스트 시 주어질 데이터
//        TestEntity entity = new TestEntity();
//        entity.setUsername("박영희");
//        entity.setAge(30);
//
//        //when : 실제 테스트 실행
//        boolean flag = repository.save(entity);
//
//        //then : 테스트 결과 단언
//        assertTrue(flag);
//        assertNotNull(entity.getId());
//    }
//
//    @Test
//    @DisplayName("유저이름과 나이를 수정해야 한다.")
//    void modifyTest() {
//        // given
//        TestEntity entity = new TestEntity();
//        entity.setUsername("최수정");
//        entity.setAge(25);
//        entity.setId("ba254e6b-1810-4ba8-81ce-d4e890f100ed");
//        // when
//        boolean flag = repository.modify(entity);
//        // then
//        assertTrue(flag);
//
//    }
//    //@Transactional
//    //@Rollback    -> 테스트시에만 기능적용하고 테스트 끝나면 다시 데이터를 원상복구한다.
//
//}