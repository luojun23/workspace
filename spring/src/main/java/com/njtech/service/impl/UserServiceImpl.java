package com.njtech.service.impl;

import com.njtech.dao.UserDao;
import com.njtech.service.UserService;

public class UserServiceImpl implements UserService {
//    public UserServiceImpl() {
//        System.out.println("UserServiceImpl");
//    }

    public void init(){
        System.out.println("初始化....");
    }

    public void destroy(){
        System.out.println("销毁.....");
    }

    public void setUserDao(UserDao userDao){
        System.out.println("属性设置完毕");
    }

    public UserServiceImpl() {
        System.out.println("UserServiceImpl");
    }
}
