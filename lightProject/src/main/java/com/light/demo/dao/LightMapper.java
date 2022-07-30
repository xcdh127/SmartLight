package com.light.demo.dao;

import com.light.demo.pojo.Light;

public interface LightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Light record);

    int insertSelective(Light record);

    Light selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Light record);

    int updateByPrimaryKey(Light record);
}