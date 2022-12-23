package com.user.service;

import com.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    @DisplayName("회원가입되지 않은 이메일을 사용해 로그인하면 예외가 발생한다.")
    void loginTest1() {
        // given
        String email = "apple22@gmail.com";
        // when

        // then
        assertThrows(RuntimeException.class, () -> {
            service.validateLogin(email, "");
        });
    }

}