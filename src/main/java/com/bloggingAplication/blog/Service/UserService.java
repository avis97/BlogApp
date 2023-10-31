package com.bloggingAplication.blog.Service;

import com.bloggingAplication.blog.Dtos.PostResponseDto;
import com.bloggingAplication.blog.Dtos.UserRequestDtos;
import com.bloggingAplication.blog.Dtos.UserResponseDtos;
import com.bloggingAplication.blog.Entity.User;
import com.bloggingAplication.blog.Exception.UserNotFoundException;

import java.util.List;

public interface UserService{

    UserResponseDtos registerNewUser(UserRequestDtos userRequestDtos);
    UserResponseDtos addUser(UserRequestDtos userRequestDtos);
    UserResponseDtos updateUser(UserRequestDtos userRepo, Integer id) throws UserNotFoundException;
    List<UserResponseDtos> getAllUser();
    UserResponseDtos getUserById(int userId) throws UserNotFoundException;
    UserResponseDtos deleteUserById(int userId) throws UserNotFoundException;
    List<PostResponseDto> getAllPostByUserId(int userId) throws UserNotFoundException;
}
