package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ComponentScan(basePackages = "com.spring.core")
// @ImportResource("applicationContext.xml")
public class AppConfig {


  @Bean
  public BeanExample getBean() {
    return new BeanExample();
  }
}
