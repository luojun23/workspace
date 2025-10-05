package com.njtech;

import com.njtech.processor.MockAopBeanPostProcess;
import com.njtech.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class ApplicationContextAppTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService bean = con.getBean(UserService.class);
        bean.show1();

    }
}
