package com.njtech.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.njtech.dao.UserDao;
import com.njtech.mapper.UserMapper;
import com.njtech.pojo.User;
import com.njtech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void String() {
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
