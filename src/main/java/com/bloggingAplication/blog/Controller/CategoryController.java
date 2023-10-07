package com.bloggingAplication.blog.Controller;


import com.bloggingAplication.blog.Dtos.CateGoryResponseDto;
import com.bloggingAplication.blog.Dtos.CategoryRequestDto;
import com.bloggingAplication.blog.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController{
    @Autowired
    CategoryService categoryService;
    @PostMapping("/addCategory")
    public CateGoryResponseDto addCategory(@RequestBody CategoryRequestDto category){
        return categoryService.addCategory(category);
    }
}
