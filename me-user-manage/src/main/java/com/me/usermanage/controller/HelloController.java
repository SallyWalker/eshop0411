package com.me.usermanage.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//检测该方法是否使用了@RequestMapping注解
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/hello")

    @ResponseBody
    //@ResponseBody的作用其实是将java对象转为json格式的数据。
    String home() {
        return "Hello ,spring boot!";
    }

}