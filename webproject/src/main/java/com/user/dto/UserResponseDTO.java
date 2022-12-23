package com.user.dto;

import com.user.entity.UserEntity;
import lombok.*;

@Setter @Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String email;
    private String username;
    private String token;

    public UserResponseDTO(UserEntity entity) {
        this.email = entity.getEmail();
        this.username = entity.getUsername();
    }
}
