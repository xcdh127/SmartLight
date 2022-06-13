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
    public String index(){

        return "index";
    }

    @RequestMapping("/default")
    public ModelAndView def(){
        ModelAndView model=new ModelAndView();
        model.setViewName("default");
        Light light = lightService.getById(1);
        model.addObject("strength",light.getStrength());
        model.addObject("frequency",light.getFrequency());
        return model;
    }

}
