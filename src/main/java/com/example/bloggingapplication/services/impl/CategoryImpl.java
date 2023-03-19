package com.example.bloggingapplication.services.impl;

import com.example.bloggingapplication.entities.Category;
import com.example.bloggingapplication.exceptions.ResourceNotFoundException;
import com.example.bloggingapplication.payloads.CategoryDto;
import com.example.bloggingapplication.repositories.CategoryRepository;
import com.example.bloggingapplication.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category savedCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer cateGoryId) {
        Category category = this.categoryRepo.findById(cateGoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", cateGoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updateCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(updateCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Integer cateGoryId) {
        Category category = this.categoryRepo.findById(cateGoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", cateGoryId));
        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
        this.categoryRepo.delete(category);
    }
}
