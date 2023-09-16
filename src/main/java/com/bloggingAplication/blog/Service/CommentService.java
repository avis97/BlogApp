package com.bloggingAplication.blog.Service;

import com.bloggingAplication.blog.Dtos.CommentRequestDto;
import com.bloggingAplication.blog.Dtos.CommentResponseDto;
import com.bloggingAplication.blog.Entity.Comments;
import com.bloggingAplication.blog.Exception.PostNotFoundException;
import com.bloggingAplication.blog.Exception.UserNotFoundException;

import java.util.List;

public interface CommentService {
    CommentResponseDto addComment(CommentRequestDto commentRequestDto) throws UserNotFoundException, PostNotFoundException;

    List<CommentResponseDto> getAllComment() throws PostNotFoundException;
}
