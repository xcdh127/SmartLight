package com.light.demo.service;

import com.light.demo.dao.LightMapper;
import com.light.demo.pojo.Light;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LightServiceTest {

    @Autowired
    private LightMapper lightMapper;

    @org.junit.Test
    public void add() {
        Light light=new Light(1,"灯箱1号",100,255);
        lightMapper.insertSelective(light);
    }

    @org.junit.Test
    public void getById() {
    }

    @org.junit.Test
    public void update() {
    }

    @org.junit.Test
    public void delete() {
    }
}