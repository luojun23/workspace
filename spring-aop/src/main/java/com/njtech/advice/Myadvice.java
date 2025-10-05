package com.njtech.advice;

import org.springframework.stereotype.Component;

//增强类 内部提供增强方法
@Component
public class Myadvice {
    public void BeforeAdvice(){
        System.out.println("前置增强");
    }

    public void AfterAdvice(){
        System.out.println("后置增强");
    }
}
