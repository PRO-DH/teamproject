package com.user.api;

import com.error.ErrorDTO;
import com.security.TokenProvider;
import com.user.dto.UserRequestDTO;
import com.user.dto.UserResponseDTO;
import com.user.entity.UserEntity;
import com.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final TokenProvider provider;

    // 회원 가입 기능
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserRequestDTO reqDto) {

        try {
            UserEntity entity = new UserEntity(reqDto);
            log.info("/auth/signup POST!! - {}", entity);

            UserEntity user = userService.createServ(entity);

            return ResponseEntity.ok().body(new UserResponseDTO(user));

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




    // 로그인 요청 처리
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserRequestDTO dto) {
        log.info("/auth/signin POST!! - login info : {}", dto);

        try {
            UserEntity user
                    = userService.validateLogin(dto.getEmail(), dto.getPassword());

            final String token = provider.create(user);

            UserResponseDTO responseDTO = new UserResponseDTO(user);
            responseDTO.setToken(token);

            return ResponseEntity.ok().body(responseDTO);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage()));
        }
    }



    // /auth/check?email=aaa@naver.com
    @GetMapping("/check")
    public ResponseEntity<?> checkEmail(String email) {
        boolean flag = userService.isDuplicate(email);
        log.info("{} 중복여부?? - {}", email, flag);
        return ResponseEntity.ok().body(flag);
    }
}








