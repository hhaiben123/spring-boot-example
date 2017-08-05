package com.example.controller;

import com.example.service.MyBatisService;
import com.example.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hhb on 2017/8/5.
 */
@RestController
public class MybatisController {

    @Autowired
    private MyBatisService myBatisService;

    @RequestMapping("/mybatis")
    public Object find(Long id) {
        return myBatisService.findById(id);
    }
}
