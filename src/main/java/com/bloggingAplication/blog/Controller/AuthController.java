package com.bloggingAplication.blog.Controller;

import com.bloggingAplication.blog.Dtos.JwtAuthRequest;
import com.bloggingAplication.blog.Dtos.JwtAuthResponse;
import com.bloggingAplication.blog.Dtos.UserRequestDtos;
import com.bloggingAplication.blog.Dtos.UserResponseDtos;
import com.bloggingAplication.blog.JwtSecurity.JwtTokenHelper;
import com.bloggingAplication.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public JwtAuthResponse createToken(@RequestBody JwtAuthRequest request, HttpServletResponse response) throws Exception {

        try {
            authenticate(request.getUsername(), request.getPassword());
            UserDetails userDetails = detailsService.loadUserByUsername(request.getUsername());
            String token = tokenHelper.generateToken(userDetails);
            ResponseCookie cookie = ResponseCookie.from("accessToken", token)
                    .httpOnly(true)
                    .secure(false)
                    .path("/api/v1/auth/login")
                    .maxAge(5*60*60)
                    .build();
            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
            return JwtAuthResponse.builder().token("Your login done successfully.").build();
           // return new ResponseEntity(token,HttpStatus.ACCEPTED);
        } catch (UsernameNotFoundException e) {
            // Customize the exception message or response if the user is not found
            throw new UsernameNotFoundException("User not found or invalid credentials");
        }
    }

    private void authenticate(String username, String password) throws Exception {

        UsernamePasswordAuthenticationToken Token=new
                UsernamePasswordAuthenticationToken(username,password);
        try {
           this.authenticationManager.authenticate(Token);
        }catch(BadCredentialsException e){
            throw new Exception("Invalid username or password");
        }
    }
    @PostMapping("/register")
    private ResponseEntity<UserResponseDtos> registerNewUser(@RequestBody UserRequestDtos userRequestDtos){

            UserResponseDtos dtos=userService.registerNewUser(userRequestDtos);

            return new ResponseEntity<UserResponseDtos>(dtos,HttpStatus.CREATED);
    }
    @PostMapping("/log-out")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies.toString());
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("accessToken")) {
                    // Invalidate the token by removing or marking it as invalid
                    cookie.setMaxAge(0); // Remove the cookie
                    cookie.setValue(null);
                    cookie.setPath("/"); // Set the cookie path
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        // Redirect the user to the login page or send a success message
        return ResponseEntity.ok("Logout successful");
    }

}
