package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {

    ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Helloworld bean = (Helloworld) appCtx.getBean("helloWorld");
    System.out.println(bean.getMessage());
    
    boolean b=appCtx.containsBean("helloworld");
    System.out.println(b);
  }
}
