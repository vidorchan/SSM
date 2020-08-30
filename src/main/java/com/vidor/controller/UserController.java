package com.vidor.controller;

import com.vidor.entity.User;
import com.vidor.entity.UserPrivileges;
import com.vidor.service.IUserPrivilegesService;
import com.vidor.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserPrivilegesService userPrivilegesService;

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }

    @RequestMapping("/helloJson")
    @ResponseBody
    public String hello1() {
        return "hello json response";
    }

    @RequestMapping("getAllUsers")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @RequestMapping("getUserPrivileges")
    public List<UserPrivileges> getAllUserPrivileges() {
        return userPrivilegesService.getAllUserUserPrivileges();
    }

    @RequestMapping("/getUserPrivileges/{pageNum}/{pageSize}")
    public List<UserPrivileges> getUserPrivilegesByPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return userPrivilegesService.getUserPrivilegesByPage(pageNum, pageSize);
    }
}
