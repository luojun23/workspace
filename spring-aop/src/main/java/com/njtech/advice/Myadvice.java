package com.njtech.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

//增强类 内部提供增强方法
@Component("myAdvice")
public class Myadvice {
    public void BeforeAdvice(JoinPoint joinPoint){
        System.out.println("当前切入对象是："+joinPoint.getTarget());
        System.out.println("表达式:"+joinPoint.getStaticPart());
        System.out.println("获得目标参数:"+joinPoint.getArgs());
        System.out.println("前置增强");
    }

    public void AfterReturingAdvice(){
        System.out.println("后置增强");
    }

    public void AroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前...");
        //环绕目标方法
        proceedingJoinPoint.proceed();//执行目标方法区
        System.out.println("环绕后....");
    }

    public void ThrowingAdvice(Throwable e){
        System.out.println(e);
        System.out.println("异常通知.....报异常才会通知");
    }

    public void AfterAdvice(){
        System.out.println("异常通知.....报异常才会通知");
    }
}
