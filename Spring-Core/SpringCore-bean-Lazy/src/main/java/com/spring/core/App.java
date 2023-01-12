package com.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring IoC container creates and initializes all singleton beans at time of application startup.
 * We can prevent this pre-initialization of a singleton bean by using the @Lazy annotation.
 * 
 * The @Lazy annotation may be used on any class directly or indirectly annotated with @Component or
 * on methods annotated with @Bean. In this example, we will use a Java-based
 * configuration(using @Configuration and @Bean).
 */
public class App {

  public static void main(String[] args) {

    AnnotationConfigApplicationContext appctx =
        new AnnotationConfigApplicationContext(AppConfig.class);

    BeanOne b1 = appctx.getBean(BeanOne.class);
    b1.print();
    appctx.close();

  }
}
