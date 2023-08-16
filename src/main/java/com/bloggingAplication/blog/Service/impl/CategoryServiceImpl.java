package com.bloggingAplication.blog.Service.impl;

import com.bloggingAplication.blog.Dtos.CateGoryResponseDto;
import com.bloggingAplication.blog.Dtos.CategoryRequestDto;
import com.bloggingAplication.blog.Entity.Category;
import com.bloggingAplication.blog.Repository.CategoryRepository;
import com.bloggingAplication.blog.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository repository;

    public  CateGoryResponseDto addCategory(CategoryRequestDto category){

        Category category1=new Category();
        category1.setTitle(category.getTitle());
        category1.setDetails(category.getDetails());

        repository.save(category1);

        CateGoryResponseDto dto=new CateGoryResponseDto();
        dto.setTitle(category1.getTitle());
        dto.setDetails(category1.getDetails());

        return dto;
    }
}
