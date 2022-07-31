package com.light.demo.controller;

import com.light.demo.pojo.Light;
import com.light.demo.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private LightService lightService;

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/default")
    public ModelAndView def() {
        ModelAndView model = new ModelAndView();
        model.setViewName("default");
        Light light = lightService.getById(1);
        model.addObject("strength", light.getStrength());
        model.addObject("frequency", light.getFrequency());
        return model;
    }

    @RequestMapping("/buttons")
    public ModelAndView buttons() {
        ModelAndView model = new ModelAndView();
        model.setViewName("buttons");
        Light light = lightService.getById(1);
        String messageStr = "";
        String messageFre = "";
        model.addObject("strength", light.getStrength());
        model.addObject("frequency", light.getFrequency());
        if (light.getStrength() == 20) {
            messageStr = "一档";
        } else if (light.getStrength() == 40) {
            messageStr = "二档";
        } else if (light.getStrength() == 60) {
            messageStr = "三档";
        } else if (light.getStrength() == 80) {
            messageStr = "四档";
        } else if (light.getStrength() == 100) {
            messageStr = "五档";
        }

        if (light.getFrequency() == 20) {
            messageFre = "一档";
        } else if (light.getFrequency() == 40) {
            messageFre = "二档";
        } else if (light.getFrequency() == 60) {
            messageFre = "三档";
        } else if (light.getFrequency() == 80) {
            messageFre = "四档";
        } else if (light.getFrequency() == 100) {
            messageFre = "五档";
        }
        model.addObject("messageStr", messageStr);
        model.addObject("messageFre", messageFre);
        return model;
    }
}
