package com.njtech.entity.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Arrays;
import java.util.Date;

@Data
public class User {
    private String username;
    private Integer age;
    private String[]hobbies;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private Address address;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", birthday=" + birthday +
                ", address="  +address+
                '}';
    }
}
