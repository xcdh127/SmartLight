package com.light.demo.dao;

import com.light.demo.pojo.Gongdan;

import java.util.List;

public interface GongdanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Gongdan record);

    int insertSelective(Gongdan record);

    Gongdan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Gongdan record);

    int updateByPrimaryKey(Gongdan record);

    List<Gongdan> list();
}