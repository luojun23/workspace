package com.njtech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.njtech.controller")
@EnableWebMvc
public class SpringMvcConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSizePerFile(1048576L);
        commonsMultipartResolver.setMaxUploadSize(10485760L);
        commonsMultipartResolver.setMaxInMemorySize(1048576);
        return commonsMultipartResolver;
    }

}
