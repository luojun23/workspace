package com.njtech;

import com.njtech.config.SpringConfig;
import com.njtech.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.transferMoney("luojun","lihua",100);
    }
}
