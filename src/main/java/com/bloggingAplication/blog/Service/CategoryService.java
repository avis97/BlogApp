package com.bloggingAplication.blog.Service;


import com.bloggingAplication.blog.Dtos.CateGoryResponseDto;
import com.bloggingAplication.blog.Dtos.CategoryRequestDto;
import com.bloggingAplication.blog.Entity.Category;

public interface CategoryService{

   CateGoryResponseDto addCategory(CategoryRequestDto category);
}
