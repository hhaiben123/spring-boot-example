package com.example.demo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.dto.User;
import org.springframework.stereotype.Service;

/**
 * Created by hhb on 2017/8/6.
 */
@Service
public class ConsumerService {

    @Reference(version = "1.0.0")
    private DubboService dubboService;

    public User findUser(){
        return dubboService.findUser();
    }

}
