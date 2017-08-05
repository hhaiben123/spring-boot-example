package com.example.dao;

import com.example.entity.TAuthor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAuthorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TAuthor record);

    int insertSelective(TAuthor record);

    TAuthor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TAuthor record);

    int updateByPrimaryKey(TAuthor record);

    List<TAuthor> findAll();

    TAuthor selectByrealName(@Param("realName") String realName);
}