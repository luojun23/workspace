package com.njtech.controller;


import com.njtech.entity.pojo.User;
import com.njtech.service.quickService;
import com.njtech.utils.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
    public String show4(@RequestBody MultipartFile file) throws IOException {
        //获得上传文件的输入流
        InputStream inputStream = file.getInputStream();
        FileOutputStream out = new FileOutputStream("E:\\" + file.getOriginalFilename());
        IOUtils.copy(inputStream,out);
        inputStream.close();
        out.close();
        return "/index.jsp";
    }

    @RequestMapping("/show5")
    //接收请求头
    public String show5(@RequestHeader("accept-encoding") String header){
        System.out.println(header);
        return "/html1.jsp";
    }


    @RequestMapping("/show6")
    //接收所有请求头
    public String show6(@RequestHeader Map<String,String>map){
        map.forEach((k,v)->{
            System.out.println(k+"---"+v);
        });
        return "/html1.jsp";
    }

    @RequestMapping("/show7")
    @ResponseBody
    //获取cookie
    public String show7(@CookieValue(value = "user",defaultValue = "") String cookie){
        return cookie;
    }

    @RequestMapping("/show8")
    @ResponseBody
    //获取cookie
    public String show8(HttpServletResponse response){
        Cookie cookie = new Cookie("user", "njtech");
        cookie.setMaxAge(60*60);//1小时
        response.addCookie(cookie);
        return "cookie已写入";
    }

    @RequestMapping("/show9")
    @ResponseBody
    //向request域中注入数据
    public String show9(HttpServletRequest request){
        request.setAttribute("user","njtech");
        return "request";
    }

    @RequestMapping("/show10")
    @ResponseBody
    //获取request域中对象
    public String show10(@RequestAttribute("user") String user){
        return user;
    }

    @RequestMapping("/forward")
    //请求转发
    public String show11(){
        return "forward:/index.jsp";
    }

    @RequestMapping("/redirect")
    //请求重定向:地址会改变http://localhost:8080/springMVC_war_exploded/index.jsp
    public String redirect(){
        return "redirect:/index.jsp";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(ModelAndView modelAndView){
        //ModelAndView封装模型数据和视图名
        //设置模型数据
        User user = new User();
        user.setUsername("luojun");
        user.setAge(23);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }

    @RequestMapping("/res")
    //直接返回字符串，需要加ResponseBody
    @ResponseBody   //告诉springMVC返回的字符串不是视图名,而是以响应体返回的数据
    public String res(){
        return "luojun";
    }
}
