package com.example.controller;

import com.example.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hhb on 2017/8/5.
 */
@RestController
public class ExceptionController {

    @Autowired
    private MyBatisService myBatisService;

    @RequestMapping("/excpet1")
    public Object excpet1() {
        return myBatisService.findAll();
    }
}
