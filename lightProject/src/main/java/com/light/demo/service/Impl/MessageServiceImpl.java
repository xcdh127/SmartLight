package com.light.demo.service.Impl;

import com.light.demo.dao.MessageMapper;
import com.light.demo.pojo.Message;
import com.light.demo.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int deleteByPrimaryKey(Long messageId) {
        return messageMapper.deleteByPrimaryKey(messageId);
    }

    @Override
    public int insert(Message record) {
        return messageMapper.insert(record);
    }

    @Override
    public int insertSelective(Message record) {
        return messageMapper.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(Long messageId) {
        return messageMapper.selectByPrimaryKey(messageId);
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return messageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return messageMapper.updateByPrimaryKey(record);
    }

    @Override
    public Message selectLastInsert() {
        return messageMapper.selectLastInsert();
    }
}
