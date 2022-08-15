package com.light.demo.controller;

import com.light.demo.pojo.User;
import com.light.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class RegisterController {

    @Autowired
    UserService userService;
    /*
     * 用户注册功能
     * */
    @ResponseBody
    @PostMapping("/register")
    public Map<String, Object> register(@Valid User user, BindingResult bindingResult) {
        Map<String, Object> map = new HashMap<>();
        //如果出现了不合法信息
        if (bindingResult.hasErrors()) {
            map.put("success", false);
            map.put("errorInfo", bindingResult.getFieldError().getDefaultMessage());
        }
        //当从数据库查出当前用户注册的用户名，则说明这个用户名已经被注册了，返回
        //用户名已注册的信息给前端
        else if (userService.findByUserName(user.getUserName()) != null) {
            map.put("success", false);
            map.put("errorInfo", "用户名已存在，请更换用户名");
        }
        //当从数据库查出当前用户注册的邮箱，则说明这个邮箱已经被注册了，返回
        //邮箱已注册的信息给前端
        else if (userService.findByEmail(user.getEmail()) != null) {
            map.put("success", false);
            map.put("errorInfo", "邮箱已存在，请更换邮箱");
        } else {
            userService.save(user);
            map.put("success", true);
        }
        return map;
    }
}
