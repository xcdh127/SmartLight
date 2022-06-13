
package com.light.demo.controller;

import com.google.gson.Gson;
import com.light.demo.model.Message;
import com.light.demo.mqtt.MQTTConnect;
import com.light.demo.pojo.Light;
import com.light.demo.service.LightService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/light")
public class LightController {

    @Autowired
    private LightService lightService;

    @Autowired
    private MQTTConnect mqttConnect;

    @ResponseBody
    @RequestMapping("/findById/{id}")
    public Map<String,Object> findById(@PathVariable Integer id){
        Map<String,Object> map=new HashMap<>();
        Light light = lightService.getById(id);
        map.put("data",light);
        map.put("errorNo",0);
        return map;
    }

    @ResponseBody
    @PostMapping("/update")
    public ModelAndView update(@RequestParam Integer lightId,
                               @RequestParam Integer strength,
                               @RequestParam Integer frequency) throws MqttException {
        ModelAndView model=new ModelAndView("default");
        lightService.update(lightId,strength,frequency);
        model.addObject("lightId",lightId);
        model.addObject("strength",strength);
        model.addObject("frequency",frequency);
        Message message = new Message();
        message.setMsg("修改灯箱参数");
        message.setStrength(strength);
        message.setFrequency(frequency);
        Gson gson=new Gson();
        String toJson = gson.toJson(message);
        mqttConnect.pub("com/iot/init", toJson,1);
        model.addObject("success",true);
        model.addObject("errorNo",0);
        return model;
    }

    @ResponseBody
    @PostMapping("/add/{lightId}/{lightName}/{strength}/{frequency}")
    public Map<String,Object> add(@PathVariable Integer lightId,
                                  @PathVariable String lightName,
                                  @PathVariable Integer strength,
                                  @PathVariable Integer frequency){
        Map<String,Object> map=new HashMap<>();
        Light light=new Light(lightId,lightName,strength,frequency);
        lightService.add(light);
        map.put("errorNo",0);
        return map;
    }

    @ResponseBody
    @DeleteMapping("/delete/{lightId}")
    public Map<String,Object> delete(@PathVariable Integer lightId){
        Map<String,Object> map=new HashMap<>();
        lightService.delete(lightId);
        map.put("errorNo",0);
        return map;
    }
}
