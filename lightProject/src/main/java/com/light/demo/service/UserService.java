package com.light.demo.service;

import com.light.demo.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    /*
     * 根据用户名查找用户实体
     * */
    public User findByUserName(String userName);

    /*
     *
     * 根据用户的邮箱查询用户实体
     * */
    public User findByEmail(String email);

    /*
     * 添加或者修改用户信息
     * */
    public void save(User user);

    /*
     * 根据用户id查找用户实体(信息)
     * */
    public User findByUserId(Integer id);

    /**
     * 根据条件获取用户总数
     *
     * @param user               条件
     * @param s_blatelyLoginTime 最近登陆时间开始
     * @param s_elatelyLoginTime 最近登陆时间结束
     * @return
     */
    public Long getCount(User user, String s_blatelyLoginTime, String s_elatelyLoginTime);

    /*
     * 根据用户注册时间查询用户实体(今日注册用户数)
     * */
    public Long todayRegist();

    /*
     * 今日登录用户数
     * */
    public Long todayLogin();

    /*
     * 根据openID查找用户
     * */
    public User findByOpenId(String openId);

}
