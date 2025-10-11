package com.njtech.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyAnnotationConfigWebApplicationContext extends AnnotationConfigApplicationContext {
    public MyAnnotationConfigWebApplicationContext() {
        //注册核心配置类
        super.register(SpringMvcConfig.class);
    }
}
