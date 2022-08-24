package com.light.demo.controller;

import com.light.demo.pojo.Gongdan;
import com.light.demo.pojo.Light;
import com.light.demo.pojo.Message;
import com.light.demo.service.GongdanService;
import com.light.demo.service.LightService;
import com.light.demo.service.MessageService;
import com.light.demo.utils.ConvertLatLngIntoRegion;
import com.light.demo.utils.LocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private LightService lightService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private GongdanService gongdanService;

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

    @RequestMapping("/user/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/user/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toXinXi")
    public String toXinXi() {
        return "xinxi";
    }

    @RequestMapping("/toDianLiang")
    public String toDianLiang() {
        return "dianliang";
    }


    @RequestMapping("/tolocation")
    public String tolocation() {
        return "location";
    }

    @RequestMapping("/location")
    public ModelAndView location() {
        ModelAndView model = new ModelAndView("location");
        Message message = messageService.selectLastInsert();
        double jingdu = message.getJingdu();
        double weidu = message.getWeidu();
        //获取精确的地理位置信息
        String location = ConvertLatLngIntoRegion.inverseGeocoding(String.valueOf(jingdu), String.valueOf(weidu));
        //获取百度静态地图url地址
        String url = LocationUtil.getUrl(jingdu, weidu);
        model.addObject("location", location);
        model.addObject("jingdu", jingdu);
        model.addObject("weidu", weidu);
        model.addObject("url", url);
        return model;
    }

    @RequestMapping("/xinxi")
    public ModelAndView xinxi() {
        ModelAndView model = new ModelAndView();
        model.setViewName("xinxi");
        //从数据库中获取最后一条插进来的数据
        Message message = messageService.selectLastInsert();
        String messageStr = "";
        //实时亮度信息
        model.addObject("strength", message.getStrength());
        //实时温度信息
        model.addObject("temperature", message.getTemperature());
        //实时湿度信息
        model.addObject("humidity", message.getHumidity());
        if (message.getStrength() == 0) {
            messageStr = "关闭";
        } else if (message.getStrength() == 20) {
            messageStr = "一档";
        } else if (message.getStrength() == 40) {
            messageStr = "二档";
        } else if (message.getStrength() == 60) {
            messageStr = "三档";
        } else if (message.getStrength() == 80) {
            messageStr = "四档";
        } else if (message.getStrength() == 100) {
            messageStr = "五档";
        }
        //实时档位信息
        model.addObject("messageStr", messageStr);
        return model;
    }

    @RequestMapping("/dianliang")
    public ModelAndView dianliang() {
        ModelAndView model = new ModelAndView();
        model.setViewName("dianliang");
        //获取插入数据库中的最后一条消息
        Message message = messageService.selectLastInsert();
        //获取实时电量信息
        Double energyused = message.getEnergyused();
        model.addObject("energyused", energyused);
        return model;
    }

    @RequestMapping("/toadd")
    public String toone() {
        return "add";
    }

    @RequestMapping("/tobuildgongdan")
    public String tobuildgongdan() {
        return "gongdan";
    }

    @RequestMapping("/togongdan")
    public ModelAndView togongdan() {
        ModelAndView model = new ModelAndView("gongdan");
        List<Gongdan> list = gongdanService.list();
        model.addObject("list", list);
        return model;
    }

    @RequestMapping("/toedit")
    public ModelAndView toedit() {
        ModelAndView model = new ModelAndView("edit");
        return model;
    }

    @RequestMapping("/todelete")
    public ModelAndView todelete() {
        ModelAndView model = new ModelAndView("delete");
        return model;
    }

}
