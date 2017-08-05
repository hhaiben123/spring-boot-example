package com.example.controller;

import com.example.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hhb on 2017/8/5.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World！";
    }

    @RequestMapping("/json")
    public String json() throws MyException{
        throw new  MyException("发生json错误");
    }
}
