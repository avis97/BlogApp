package com.bloggingAplication.blog.Controller;

import com.bloggingAplication.blog.Dtos.UserRequestDtos;
import com.bloggingAplication.blog.Dtos.UserResponseDtos;
import com.bloggingAplication.blog.Entity.User;
import com.bloggingAplication.blog.Exception.UserNotFoundException;
import com.bloggingAplication.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public UserResponseDtos addUser(@Valid @RequestBody UserRequestDtos userRequestDtos){
         return userService.addUser(userRequestDtos);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody UserRequestDtos userRepo, @PathVariable("id") Integer id) throws UserNotFoundException {
         UserResponseDtos user;
         try{
             user=userService.updateUser(userRepo,id);
         }catch(UserNotFoundException e){
             return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
         }

         return new ResponseEntity(user,HttpStatus.ACCEPTED);
    }
}
