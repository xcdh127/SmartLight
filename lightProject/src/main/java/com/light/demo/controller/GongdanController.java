package com.light.demo.controller;

import com.light.demo.pojo.Gongdan;
import com.light.demo.service.GongdanService;
import com.light.demo.utils.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gongdan")
@Slf4j
public class GongdanController {

    @Autowired
    private GongdanService gongdanService;

    @RequestMapping("/save")
    public ModelAndView save(@RequestParam Map<String, Object> params) {
        ModelAndView model = new ModelAndView("gongdan");
        String event = (String) params.get("event");
        String tel = (String) params.get("tel");
        Gongdan gongdan = new Gongdan(event, tel);
        String dateStr = DateUtil.getCurrentDateStr();
        gongdan.setBuildtime(dateStr);
        gongdan.setIsdone(0);
        log.info(dateStr + ",发送派工单，联系人电话：" + tel + ",派工事由：" + event);
        gongdanService.insert(gongdan);
        List<Gongdan> list = gongdanService.list();
        model.addObject("list", list);
        return model;
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("gongdan");
        List<Gongdan> list = gongdanService.list();
        model.addObject("list", list);
        return model;
    }

    @RequestMapping("/update")
    public ModelAndView update(@RequestParam(required = false) Long id,
                               @RequestParam Integer isdone) {
        ModelAndView model = new ModelAndView("gongdan");
        Gongdan gongdan = gongdanService.selectByPrimaryKey(id);
        gongdan.setIsdone(isdone);
        gongdanService.updateByPrimaryKey(gongdan);
        List<Gongdan> list = gongdanService.list();
        model.addObject("list", list);
        return model;
    }

}
