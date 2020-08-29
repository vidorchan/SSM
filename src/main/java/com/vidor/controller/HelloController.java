package com.vidor.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }

    @RequestMapping("/helloJson")
    @ResponseBody
    public String hello1() {
        return "hello json response";
    }
}
