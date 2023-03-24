package com.example.bloggingapplication.payloads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 4, message = "UserName must be minimum of 4 characters !!")
    private String name;

    @NotEmpty
    @Email(message = "Email address is not valid !!")
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Size(min = 5, max = 16, message = "Password must be minimum of 5 characters and maximum of 16 characters !!")
    private String password;

    @NotEmpty
    private String about;

    private Set<RoleDto> roles = new HashSet<>();

    @JsonIgnore
    public String getPassword(){
        return  this.password;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
