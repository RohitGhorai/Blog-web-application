package com.example.bloggingapplication.services;

import com.example.bloggingapplication.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer cateGoryId);
    CategoryDto getCategoryById(Integer cateGoryId);
    List<CategoryDto> getAllCategories();
    void deleteCategory(Integer categoryId);
}
