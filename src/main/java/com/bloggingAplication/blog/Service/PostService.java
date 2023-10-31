package com.bloggingAplication.blog.Service;

import com.bloggingAplication.blog.Dtos.PostRequestDtos;
import com.bloggingAplication.blog.Dtos.PostResponseDto;
import com.bloggingAplication.blog.Entity.Post;
import com.bloggingAplication.blog.Exception.CategoryNotFoundException;
import com.bloggingAplication.blog.Exception.PostNotFoundException;
import com.bloggingAplication.blog.Exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService{
    PostResponseDto addPost(PostRequestDtos postRequestDtos) throws UserNotFoundException, CategoryNotFoundException;
    PostResponseDto getPostById(Integer postId) throws PostNotFoundException;
    PostResponseDto updatePost(PostRequestDtos requestDto,Integer postId) throws PostNotFoundException;
    List<PostResponseDto> getAllPost();
}
