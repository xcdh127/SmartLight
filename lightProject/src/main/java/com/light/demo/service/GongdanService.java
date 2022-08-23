package com.light.demo.service;

import com.light.demo.pojo.Gongdan;

import java.util.List;

public interface GongdanService {
    int deleteByPrimaryKey(Long id);

    int insert(Gongdan record);

    int insertSelective(Gongdan record);

    Gongdan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Gongdan record);

    int updateByPrimaryKey(Gongdan record);

    List<Gongdan> list();
}
