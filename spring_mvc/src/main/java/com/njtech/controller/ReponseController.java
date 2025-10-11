package com.njtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class ReponseController {

    @RequestMapping("/res")
    @ResponseBody
    public String res(){
        return "{\"username\":\"luojun\",\"age\":23}";
    }

}
