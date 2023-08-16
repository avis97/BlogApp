package com.bloggingAplication.blog.Controller;

import com.bloggingAplication.blog.Dtos.JwtAuthRequest;
import com.bloggingAplication.blog.Dtos.JwtAuthResponse;
import com.bloggingAplication.blog.Dtos.UserRequestDtos;
import com.bloggingAplication.blog.Dtos.UserResponseDtos;
import com.bloggingAplication.blog.JwtSecurity.JwtTokenHelper;
import com.bloggingAplication.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController{
    @Autowired
    JwtTokenHelper tokenHelper;
    @Autowired
    UserDetailsService detailsService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse>  createToken(@RequestBody JwtAuthRequest request){

        authenticate(request.getUsername(),request.getPassword());
        UserDetails userDetails= detailsService.loadUserByUsername(request.getUsername());
        String token=tokenHelper.generateToken(userDetails);

        JwtAuthResponse response=new JwtAuthResponse();
        response.setToken(token);

        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.ACCEPTED);
    }

    private void authenticate(String username, String password){

        UsernamePasswordAuthenticationToken Token=new
                UsernamePasswordAuthenticationToken(username,password);
        try {
            authenticationManager.authenticate(Token);
        }catch(Exception e){
            throw new DisabledException("User Is Disable");
        }
    }
    @PostMapping("/register")
    private ResponseEntity<UserResponseDtos> registerNewUser(@RequestBody UserRequestDtos userRequestDtos){

            UserResponseDtos dtos=userService.registerNewUser(userRequestDtos);

            return new ResponseEntity<UserResponseDtos>(dtos,HttpStatus.CREATED);
    }

}
