package com.njtech.mapper;

import com.njtech.entity.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
