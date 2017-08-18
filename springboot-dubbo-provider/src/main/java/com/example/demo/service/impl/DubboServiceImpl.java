package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.dto.User;
import com.example.demo.service.DubboService;


/**
 * Created by hhb on 2017/8/5.
 * 注册为 Dubbo 服务
 */
@Service(version = "1.0.0")
public class DubboServiceImpl implements DubboService {
    @Override
    public User findUser() {
        User user = new User();
        user.setUserName("Dubbo");
        user.setAge(10);
        return user;
    }
}
