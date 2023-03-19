package com.example.bloggingapplication.repositories;

import com.example.bloggingapplication.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
