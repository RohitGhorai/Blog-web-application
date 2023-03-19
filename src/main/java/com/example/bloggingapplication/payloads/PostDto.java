package com.example.bloggingapplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private Integer postId;
    @NotBlank
    @Size(min = 4, message = "Post's title must be minimum of 4 characters !!")
    private String title;
    @NotBlank
    @Size(min = 10, message = "Post's content must be minimum of 10 characters !!")
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
    private Set<CommentDto> comments = new HashSet<>();
}
