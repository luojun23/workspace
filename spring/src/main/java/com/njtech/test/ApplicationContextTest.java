package com.njtech.test;

import com.njtech.beans.OtherBean;
import com.njtech.config.SpringConfig;
import com.njtech.dao.UserDao;
import com.njtech.service.UserService;
import com.njtech.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
//        Object date = con.getBean("dataSource");
//        System.out.println(date);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        UserService userService = (UserService)applicationContext.getBean("userService");
//        userService.String();
        OtherBean bean = (OtherBean)applicationContext.getBean("OtherBean");
        System.out.println(bean);
    }
}
