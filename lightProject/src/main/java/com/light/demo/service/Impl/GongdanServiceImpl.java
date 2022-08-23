package com.light.demo.service.Impl;

import com.light.demo.dao.GongdanMapper;
import com.light.demo.pojo.Gongdan;
import com.light.demo.service.GongdanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GongdanServiceImpl implements GongdanService {

    @Autowired
    private GongdanMapper gongdanMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return gongdanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Gongdan record) {
        return gongdanMapper.insert(record);
    }

    @Override
    public int insertSelective(Gongdan record) {
        return gongdanMapper.insertSelective(record);
    }

    @Override
    public Gongdan selectByPrimaryKey(Long id) {
        return gongdanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Gongdan record) {
        return gongdanMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Gongdan record) {
        return gongdanMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Gongdan> list() {
        return gongdanMapper.list();
    }
}
