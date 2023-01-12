package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
  @Autowired
  BeanOne beanOne;

  public static void main(String[] args) {
    ApplicationContext appctx = new AnnotationConfigApplicationContext(ParentConfig.class);
    BeanOne beanOne = appctx.getBean(BeanOne.class);
    beanOne.print();

    // When accessing more than one config file mention @Import annotation where all your dependent
    // @Configuration files
    A a = appctx.getBean(A.class);
    a.print();
  }
}
