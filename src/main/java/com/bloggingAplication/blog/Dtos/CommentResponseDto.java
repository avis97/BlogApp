package com.bloggingAplication.blog.Dtos;

import com.bloggingAplication.blog.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponseDto {
    private String content;
    private int postId;
    private int userId;
    private PostResponseDto postResponseDto;
    private Date time;
}
