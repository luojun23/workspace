package com.njtech.entity.pojo;

import lombok.Data;

@Data
public class Address {
    private String city;
    private String area;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
