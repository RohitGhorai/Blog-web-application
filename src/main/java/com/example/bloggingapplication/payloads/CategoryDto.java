package com.example.bloggingapplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer categoryId;
    @NotBlank
    @Size(min = 4, message = "Category's title must be minimum of 4 characters")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10, message = "Category's description must be minimum of 10 characters")
    private String categoryDescription;
}
