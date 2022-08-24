package com.light.demo.controller;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaModel;
import com.aliyun.teautil.models.RuntimeOptions;
import com.light.demo.pojo.Gongdan;
import com.light.demo.service.GongdanService;
import com.light.demo.utils.DateUtil;
import com.light.demo.utils.MessageUtil;
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
    public ModelAndView save(@RequestParam Map<String, Object> params) throws Exception {
        ModelAndView model = new ModelAndView("gongdan");
        String event = (String) params.get("event");
        String tel = (String) params.get("tel");
        Gongdan gongdan = new Gongdan(event, tel);
        String dateStr = DateUtil.getCurrentDateStr();
        gongdan.setBuildtime(dateStr);
        gongdan.setIsdone(0);
        String str = tel.substring(tel.length() - 6, tel.length());
        System.out.println("{\"code\":\"" + str + "\"}");
        //发送短信
        /*com.aliyun.dysmsapi20170525.Client client = MessageUtil.createClient("", "");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers("")
                .setTemplateParam("{\"code\":\"" + str + "\"}");
        RuntimeOptions runtime = new RuntimeOptions();
        SendSmsResponse resp = client.sendSmsWithOptions(sendSmsRequest, runtime);
        com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(TeaModel.buildMap(resp)));*/
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

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam(required = false) Long id) {
        ModelAndView model = new ModelAndView("gongdan");
        gongdanService.deleteByPrimaryKey(id);
        List<Gongdan> list = gongdanService.list();
        model.addObject("list", list);
        return model;
    }

}
