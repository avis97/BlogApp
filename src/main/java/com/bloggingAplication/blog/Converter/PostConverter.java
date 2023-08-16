package com.bloggingAplication.blog.Converter;


import com.bloggingAplication.blog.Dtos.PostRequestDtos;
import com.bloggingAplication.blog.Dtos.PostResponseDto;
import com.bloggingAplication.blog.Entity.Post;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PostConverter{
    public static Post postRequestDtoToPost(PostRequestDtos postRequestDtos){
        return Post.builder()
                .postTitle(postRequestDtos.getPostTitle())
                .content(postRequestDtos.getContent())
                .imageName(postRequestDtos.getImageName())
                .build();
    }
    public static PostResponseDto postToPostResponseDto(Post post){
        return PostResponseDto.builder()
                .postTitle(post.getPostTitle())
                .postContent(post.getContent())
                .imageName(post.getImageName())
                .user_id(post.getUser().getId())
                .category_id(post.getCategory().getCatId())
                .build();
    }
    public static PostRequestDtos PostResponseToRequestDto(PostResponseDto dto){
        return PostRequestDtos.builder()
                .postTitle(dto.getPostTitle())
                .content(dto.getPostContent())
                .imageName(dto.getImageName())
                .userId(dto.getUser_id())
                .categoryId(dto.getCategory_id())
                .build();
    }
}
