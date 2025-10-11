package com.njtech.config;

import com.njtech.inteceptors.MyInterceptor1;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MySpringMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //开启defaultServlet 可以处理静态资源了
        configurer.enable();
    }
}
