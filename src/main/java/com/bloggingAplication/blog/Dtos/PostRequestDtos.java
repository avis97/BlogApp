package com.bloggingAplication.blog.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequestDtos{
    private String postTitle;
    private String content;
    private String imageName;
    private int userId;
    private int categoryId;

}
