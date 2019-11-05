package com.mercury.gateway.controller;


import com.mercury.gateway.entity.User;
import com.mercury.gateway.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public User info(){
        return userService.info();
    }

}
