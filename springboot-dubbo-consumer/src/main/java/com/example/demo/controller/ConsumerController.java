package com.example.demo.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.dto.User;
import com.example.demo.service.ConsumerService;
import com.example.demo.service.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hhb on 2017/8/6.
 */
@RestController
public class ConsumerController {


    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/dubbo")
    public User dubbo(){
        return consumerService.findUser();
    }
}
