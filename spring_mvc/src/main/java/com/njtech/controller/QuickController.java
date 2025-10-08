package com.njtech.controller;


import com.njtech.entity.pojo.User;
import com.njtech.service.quickService;
import com.njtech.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class QuickController {

    @Autowired
    private quickService quickService;

    @RequestMapping("/show")
    //数组不需要加RequestParam，而集合需要
    public String show(@RequestParam List<Integer>hobby){
        for (Integer integer : hobby) {
            System.out.println(integer);
        }
        System.out.println(quickService);
        return "/index.jsp";
    }

    @RequestMapping("/show1")
    public String show1(@RequestParam(value = "username",required = true,defaultValue = "haohao") String username,Integer age){
        System.out.println(username+"----"+age);
        return "/index.jsp";
    }

    @PostMapping("/show2")
    public String show2(@RequestBody User user){
        System.out.println(user);
        return "/index.jsp";
    }

    @GetMapping("/show3/{id}")
    public String show3(@PathVariable("id") Integer id){
        System.out.println(id);
        return "/index.jsp";
    }

    @PostMapping("/show4")
    //文件上传(springmvc默认未开启文件上传，需要自动开启文件上传解析器)
    public String show4(@RequestBody MultipartFile file){
        System.out.println(file);
        return "/index.jsp";
    }

    @RequestMapping("/show5")
    public String show5(){
        return "/html1.jsp";
    }
}
