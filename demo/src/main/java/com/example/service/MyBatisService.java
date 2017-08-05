package com.example.service;

import com.example.entity.TAuthor;
import com.example.exception.MyException;

import java.util.List;

/**
 * Created by hhb on 2017/8/5.
 */
public interface  MyBatisService {

    public TAuthor findById(Long id);

    public List<TAuthor> findAll();
}
