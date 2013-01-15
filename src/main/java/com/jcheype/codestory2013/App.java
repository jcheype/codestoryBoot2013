package com.jcheype.codestory2013;

import com.jcheype.webServer.spring.SpringWebServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.management.ManagementFactory;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SpringWebServer springWebServer = context.getBean(SpringWebServer.class);
        logger.debug("STARTING");
        springWebServer.setPort(9999);
        springWebServer.start();
    }
}
