package com.light.demo.service.Impl;

import com.light.demo.dao.LightMapper;
import com.light.demo.pojo.Light;
import com.light.demo.service.LightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LightServiceImpl implements LightService {

    @Autowired
    private LightMapper lightMapper;

    @Override
    public void add(Light light) {
        lightMapper.insert(light);
    }

    @Override
    public Light getById(Integer id) {
        return lightMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Integer id, Integer strength, Integer frequency) {
        Light light = lightMapper.selectByPrimaryKey(id);
        light.setStrength(strength);
        light.setFrequency(frequency);
        lightMapper.updateByPrimaryKeySelective(light);
        log.info("更新灯箱信息成功，修改后的强度为:{}，修改后的频率为:{}",strength,frequency);
    }

    @Override
    public void updateStr(Integer id, Integer strength) {
        Light light = lightMapper.selectByPrimaryKey(id);
        light.setStrength(strength);
        lightMapper.updateByPrimaryKeySelective(light);
        log.info("更新灯箱信息成功，修改后的强度为:{}",strength);

    }

    @Override
    public void updateFre(Integer id, Integer frequency) {
        Light light = lightMapper.selectByPrimaryKey(id);
        light.setFrequency(frequency);
        lightMapper.updateByPrimaryKeySelective(light);
        log.info("更新灯箱信息成功，修改后的频率为:{}",frequency);
    }

    @Override
    public void delete(Integer id) {
        lightMapper.deleteByPrimaryKey(id);
    }




}
