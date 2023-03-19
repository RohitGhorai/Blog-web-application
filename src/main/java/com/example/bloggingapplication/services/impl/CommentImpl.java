package com.example.bloggingapplication.services.impl;

import com.example.bloggingapplication.entities.Comment;
import com.example.bloggingapplication.entities.Post;
import com.example.bloggingapplication.exceptions.ResourceNotFoundException;
import com.example.bloggingapplication.payloads.CommentDto;
import com.example.bloggingapplication.repositories.CommentRepository;
import com.example.bloggingapplication.repositories.PostRepository;
import com.example.bloggingapplication.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepository.save(comment);
        CommentDto commentDto1 = this.modelMapper.map(savedComment, CommentDto.class);
        return commentDto1;
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));
        this.commentRepository.delete(comment);
    }
}
