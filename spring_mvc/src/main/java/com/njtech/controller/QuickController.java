package com.njtech.controller;


import com.njtech.service.quickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuickController {

    @Autowired
    private quickService quickService;

    @RequestMapping("/show")
    public String show(){
        System.out.println(quickService);
        return "/index.jsp";
    }

}
