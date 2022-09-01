package com.light.demo.dao;

import com.light.demo.pojo.Error;

public interface ErrorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Error record);

    int insertSelective(Error record);

    Error selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Error record);

    int updateByPrimaryKey(Error record);
}