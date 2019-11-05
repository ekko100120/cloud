package com.mercury.gateway2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {

    @GetMapping("/hello")
    public String hello(){
        return  "GateWay-II Hello service";
    }
}
