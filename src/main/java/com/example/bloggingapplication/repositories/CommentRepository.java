package com.example.bloggingapplication.repositories;

import com.example.bloggingapplication.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
