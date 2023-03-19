package com.example.bloggingapplication.services;

import com.example.bloggingapplication.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);
}
