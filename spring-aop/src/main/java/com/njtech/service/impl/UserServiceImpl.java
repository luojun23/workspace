package com.njtech.service.impl;

import com.njtech.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public void show1() {
        System.out.println("show1...");
    }

    @Override
    public void show2() {
        System.out.println("show2.....");
    }
}
