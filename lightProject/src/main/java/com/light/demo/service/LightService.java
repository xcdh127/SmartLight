package com.light.demo.service;

import com.light.demo.pojo.Light;

/*灯控*/
public interface LightService {
    //增加灯箱设置
    public void add(Light light);

    //通过id获取灯箱信息
    public Light getById(Integer id);

    //修改灯箱设置
    public void update(Integer id, Integer strength, Integer frequency);

    //删除灯箱设置
    public void delete(Integer id);

}
