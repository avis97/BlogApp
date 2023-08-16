package com.bloggingAplication.blog.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> map=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)-> {
                String filedName=((FieldError)error).getField();
                String msg=error.getDefaultMessage();
                map.put(filedName,msg);
        });
        return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
    }
}
