package com.light.demo.service.Impl;

import com.light.demo.dao.UserMapper;
import com.light.demo.pojo.User;
import com.light.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);

    }

    @Override
    public User findByUserId(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long getCount(User user, String s_blatelyLoginTime, String s_elatelyLoginTime) {
        return null;
    }

    @Override
    public Long todayRegist() {
        return null;
    }

    @Override
    public Long todayLogin() {
        return null;
    }

    @Override
    public User findByOpenId(String openId) {
        return null;
    }
}
