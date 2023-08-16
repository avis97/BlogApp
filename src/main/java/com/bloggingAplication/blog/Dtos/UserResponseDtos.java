package com.bloggingAplication.blog.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDtos{
    private int userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String about;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JwtAuthResponse{
        private String token;
    }
}
