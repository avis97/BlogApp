package com.bloggingAplication.blog.Controller;

import com.bloggingAplication.blog.Dtos.CommentRequestDto;
import com.bloggingAplication.blog.Dtos.CommentResponseDto;
import com.bloggingAplication.blog.Exception.PostNotFoundException;
import com.bloggingAplication.blog.Exception.UserNotFoundException;
import com.bloggingAplication.blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController{
    @Autowired
    CommentService commentService;

    @PostMapping("/addComments")
    public ResponseEntity addComment(@RequestBody CommentRequestDto commentRequestDto)
            throws UserNotFoundException, PostNotFoundException{

       CommentResponseDto commentResponseDto;

       try{
           commentResponseDto=commentService.addComment(commentRequestDto);
       }catch(PostNotFoundException e){

           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

       }catch (UserNotFoundException e){

           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity(commentResponseDto,HttpStatus.ACCEPTED);
    }
}
