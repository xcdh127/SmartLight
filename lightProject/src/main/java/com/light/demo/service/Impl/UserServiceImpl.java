package com.light.demo.service.Impl;

import com.light.demo.dao.UserMapper;
import com.light.demo.pojo.User;
import com.light.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findByUserId(Integer id) {
        return null;
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
