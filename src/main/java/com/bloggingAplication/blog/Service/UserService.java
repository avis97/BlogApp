package com.bloggingAplication.blog.Service;

import com.bloggingAplication.blog.Dtos.UserRequestDtos;
import com.bloggingAplication.blog.Dtos.UserResponseDtos;
import com.bloggingAplication.blog.Entity.User;
import com.bloggingAplication.blog.Exception.UserNotFoundException;

public interface UserService{

    UserResponseDtos registerNewUser(UserRequestDtos userRequestDtos);
    UserResponseDtos addUser(UserRequestDtos userRequestDtos);

    UserResponseDtos updateUser(UserRequestDtos userRepo, Integer id) throws UserNotFoundException;
}
