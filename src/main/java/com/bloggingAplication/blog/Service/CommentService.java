package com.bloggingAplication.blog.Service;

import com.bloggingAplication.blog.Dtos.CommentRequestDto;
import com.bloggingAplication.blog.Dtos.CommentResponseDto;
import com.bloggingAplication.blog.Exception.PostNotFoundException;
import com.bloggingAplication.blog.Exception.UserNotFoundException;

public interface CommentService {
    CommentResponseDto addComment(CommentRequestDto commentRequestDto) throws UserNotFoundException, PostNotFoundException;
}
