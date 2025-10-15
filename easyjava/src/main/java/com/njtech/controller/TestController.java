package com.njtech.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class TestController {
    @RequestMapping("/")
    public String  test(){
        return "hello";
    }
}
