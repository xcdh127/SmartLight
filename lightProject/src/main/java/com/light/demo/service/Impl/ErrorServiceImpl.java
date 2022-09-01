package com.light.demo.service.Impl;

import com.light.demo.dao.ErrorMapper;
import com.light.demo.pojo.Error;
import com.light.demo.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorServiceImpl implements ErrorService {

    @Autowired
    private ErrorMapper errorMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return errorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Error record) {
        return errorMapper.insert(record);
    }

    @Override
    public int insertSelective(Error record) {
        return errorMapper.insertSelective(record);
    }

    @Override
    public Error selectByPrimaryKey(Long id) {
        return errorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Error record) {
        return errorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Error record) {
        return errorMapper.updateByPrimaryKey(record);
    }
}
