package com.bloggingAplication.blog.Converter;

import com.bloggingAplication.blog.Dtos.CommentResponseDto;
import com.bloggingAplication.blog.Entity.Comments;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommentConverter{
    public static CommentResponseDto commentToCommentResponseDto(Comments comments){
        return CommentResponseDto.builder()
                .content(comments.getCommentContent())
                .postId(comments.getPost().getPostId())
                .userId(comments.getUser().getId())
                .time(comments.getDateTime())
                .build();
    }
}
