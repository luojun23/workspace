package com.njtech.beans;

import com.njtech.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
    public static void main(String[] args) {
        //创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建一个读取器(xml文件)
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //加载配置文件给工厂
        reader.loadBeanDefinitions("beans.xml");
        //根据id获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");

       // System.out.println(userService);

//
//        UserDao userDao = (UserDao) beanFactory.getBean("UserDao");
//
//        System.out.println(userDao);
//
    }
}
