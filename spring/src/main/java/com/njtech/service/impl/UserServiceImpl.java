package com.njtech.service.impl;

import com.njtech.dao.UserDao;
import com.njtech.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public String toString() {
        return "UserServiceImpl";
    }
    public void setUserDao(UserDao userDao){
        System.out.println("BeanFactory去调用该方法获取UserDao并设置到此处"+userDao);
    }
}
