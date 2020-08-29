package com.vidor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
