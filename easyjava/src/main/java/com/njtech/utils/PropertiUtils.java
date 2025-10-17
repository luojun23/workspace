package com.njtech.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class PropertiUtils{
    private static Properties properties = new Properties();
    private static Map<String,String>PRO_MAP = new ConcurrentHashMap<>();

    static{
        BufferedInputStream is = null;
        try {
            //读取配置文件地址
            //is = new BufferedInputStream(new FileInputStream("src/main/resources/application.properties"));
            is = (BufferedInputStream) PropertiUtils.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(is);

            for (String key : properties.stringPropertyNames()) {
                PRO_MAP.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getName(String s){
        return PRO_MAP.get(s);
    }
}
