package com.njtech.processor;

import com.njtech.advice.Myadvice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class MockAopBeanPostProcess implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getPackage().getName().equals("com.njtech.service.impl")){
            //生成当前Bean的Proxy对象
            Object beanProxy = Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (Object proxy, Method method, Object[] args) -> {
                        //执行增强对象的before方法
                        Myadvice bean1 = applicationContext.getBean(Myadvice.class);
                        bean1.BeforeAdvice();
                        //执行目标对象的目标方法
                        Object result = method.invoke(bean, args);
                        //执行增强对象的after方法
                        bean1.AfterAdvice();
                        return result;
                    }
            );
            return beanProxy;
        }
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
