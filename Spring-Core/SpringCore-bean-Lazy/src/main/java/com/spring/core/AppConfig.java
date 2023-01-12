package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = "com.spring.core")
public class AppConfig {

  @Lazy(value = true)
  @Bean
  public BeanOne b1() {
    return new BeanOne();
  }

  @Bean
  public BeanTwo b2() {
    return new BeanTwo();
  }
}
