package com.bloggingAplication.blog.Converter;
import com.bloggingAplication.blog.Dtos.UserRequestDtos;
import com.bloggingAplication.blog.Dtos.UserResponseDtos;
import com.bloggingAplication.blog.Entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    public static User RequestDtoToUser(UserRequestDtos userRequestDtos){

        return User.builder()
                .name(userRequestDtos.getUser_name())
                .email(userRequestDtos.getUser_email())
                .about(userRequestDtos.getAbout())
                .password(userRequestDtos.getPassword())
                .user_mobile(userRequestDtos.getUser_mobile())
                .build();

    }

    public static UserResponseDtos UserToResponseDto(User user){

        return UserResponseDtos.builder()
                .userId(user.getId())
                .userName((user.getName()))
                .userPhone(user.getUser_mobile())
                .userEmail(user.getEmail())
                .about(user.getAbout())
                .build();
    }
}
