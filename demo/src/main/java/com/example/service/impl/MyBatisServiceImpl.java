package com.example.service.impl;

import com.example.dao.TAuthorMapper;
import com.example.entity.TAuthor;
import com.example.service.MyBatisService;
import com.example.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hhb on 2017/8/5.
 */
@Service
public class MyBatisServiceImpl implements MyBatisService {

    @Autowired
    private TAuthorMapper tAuthorMapper;

    @Override
    public TAuthor findById(Long id) {
       TAuthor tAuthor = tAuthorMapper.selectByPrimaryKey(id);
       return tAuthor;
    }

    @Override
    public List<TAuthor> findAll() {
        return tAuthorMapper.findAll();
    }
}
