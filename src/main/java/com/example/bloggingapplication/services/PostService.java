package com.example.bloggingapplication.services;

import com.example.bloggingapplication.payloads.PostDto;
import com.example.bloggingapplication.payloads.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
    PostDto updatePost(PostDto postDto, Integer postId);
    PostDto getPostByPostId(Integer postId);
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);
    void deletePost(Integer postId);
    List<PostDto> getPostsByCategoryId(Integer categoryId);
    List<PostDto> getPostsByUserId(Integer userId);
    List<PostDto> searchPosts(String keywords);
}
