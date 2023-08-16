package com.bloggingAplication.blog.Dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponseDto{
    private String postTitle;
    private String postContent;
    private String imageName;
    private int user_id;
    private int category_id;
}
