package com.njtech.listener;

import com.njtech.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        sce.getServletContext().setAttribute("applicationContext",applicationContext);

    }
}
