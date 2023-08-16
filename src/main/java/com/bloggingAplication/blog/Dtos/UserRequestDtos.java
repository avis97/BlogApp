package com.bloggingAplication.blog.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDtos{

    @NotEmpty
    @Size(min=4 ,message ="Name must be 5 character.")
    private String user_name;
    @Email
    private String user_email;
    @NotEmpty
    @Size(max=100)
    private String about;
//    @NotEmpty
//    @Size(min=3,max = 8,message = "Password length must be 3-8 character")
    private String password;
    @NotEmpty
    private String user_mobile;
}
