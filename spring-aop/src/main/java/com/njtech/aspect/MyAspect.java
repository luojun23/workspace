package com.njtech.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(void com.njtech.service.impl.UserServiceImpl.show1())")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("前置增强");
    }

}
