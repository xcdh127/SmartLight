
package com.light.demo.controller;

import com.light.demo.pojo.Message;
import com.light.demo.mqtt.MQTTConnect;
import com.light.demo.pojo.Light;
import com.light.demo.service.LightService;
import com.light.demo.utils.JsonUtils;
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
    public Map<String, Object> findById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        Light light = lightService.getById(id);
        map.put("data", light);
        map.put("errorNo", 0);
        return map;
    }

    @ResponseBody
    @PostMapping("/update")
    public ModelAndView update(@RequestParam Integer lightId,
                               @RequestParam Integer strength,
                               @RequestParam Integer frequency) throws MqttException {
        ModelAndView model = new ModelAndView("default");
        lightService.update(lightId, strength, frequency);
        model.addObject("lightId", lightId);
        model.addObject("strength", strength);
        model.addObject("frequency", frequency);
        Message message = new Message();
        message.setMsg("修改灯箱参数");
        message.setStrength(strength);
//        message.setFrequency(frequency);
        String toJson = JsonUtils.toJsonString(message);
        mqttConnect.pub("com/iot/init", toJson, 1);
        model.addObject("success", true);
        model.addObject("errorNo", 0);
        return model;
    }

    @ResponseBody
    @PostMapping("/updateButtonStr/{lightId}/{strength}")
    public ModelAndView updateButtonStr(@RequestParam(value = "lightId", required = false, defaultValue = "1") Integer lightId,
                                        @RequestParam(value = "strength", required = false) Integer strength) throws MqttException {
        ModelAndView model = new ModelAndView("buttons");
        lightService.updateStr(lightId, strength);
        Light light = lightService.getById(1);
        String messageStr = "";
        if (strength == 0) {
            messageStr = "零档";
        } else if (strength == 20) {
            messageStr = "一档";
        } else if (strength == 40) {
            messageStr = "二档";
        } else if (strength == 60) {
            messageStr = "三档";
        } else if (strength == 80) {
            messageStr = "四档";
        } else if (strength == 100) {
            messageStr = "五档";
        }
        model.addObject("lightId", lightId);
        model.addObject("strength", strength);
        model.addObject("frequency", light.getFrequency());
        model.addObject("messageStr", messageStr);
        Message message = new Message();
        message.setMsg("修改灯箱参数");
        message.setStrength(strength);
//        message.setFrequency(light.getFrequency());
        String toJson = JsonUtils.toJsonString(message);
        mqttConnect.pub("com/iot/init", toJson, 1);
        model.addObject("success", true);
        model.addObject("errorNo", 0);
        return model;
    }

    @ResponseBody
    @PostMapping("/updateButtonFre/{lightId}/{frequency}")
    public ModelAndView updateButtonFre(@RequestParam(value = "lightId", required = false, defaultValue = "1") Integer lightId,
                                        @RequestParam(value = "frequency", required = false) Integer frequency) throws MqttException {
        ModelAndView model = new ModelAndView("buttons");
        lightService.updateFre(lightId, frequency);
        Light light = lightService.getById(1);
        String messageFre = "";
        if (frequency == 20) {
            messageFre = "一档";
        } else if (frequency == 40) {
            messageFre = "二档";
        } else if (frequency == 60) {
            messageFre = "三档";
        } else if (frequency == 80) {
            messageFre = "四档";
        } else if (frequency == 100) {
            messageFre = "五档";
        }
        model.addObject("lightId", lightId);
        model.addObject("strength", light.getStrength());
        model.addObject("frequency", frequency);
        model.addObject("messageFre", messageFre);
        Message message = new Message();
        message.setMsg("修改灯箱参数");
        message.setStrength(light.getStrength());
//        message.setFrequency(frequency);
        String toJson = JsonUtils.toJsonString(message);
        mqttConnect.pub("com/iot/init", toJson, 1);
        model.addObject("success", true);
        model.addObject("errorNo", 0);
        return model;
    }

    @ResponseBody
    @PostMapping("/add/{lightId}/{lightName}/{strength}/{frequency}")
    public Map<String, Object> add(@PathVariable Integer lightId,
                                   @PathVariable String lightName,
                                   @PathVariable Integer strength,
                                   @PathVariable Integer frequency) {
        Map<String, Object> map = new HashMap<>();
        Light light = new Light(lightId, lightName, strength, frequency);
        lightService.add(light);
        map.put("errorNo", 0);
        return map;
    }

    @ResponseBody
    @DeleteMapping("/delete/{lightId}")
    public Map<String, Object> delete(@PathVariable Integer lightId) {
        Map<String, Object> map = new HashMap<>();
        lightService.delete(lightId);
        map.put("errorNo", 0);
        return map;
    }
}
