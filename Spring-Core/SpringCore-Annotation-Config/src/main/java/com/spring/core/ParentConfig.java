package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

class A {
  public void print() {
    System.out.println("Inside A class");
  }
}


@Configuration
@Import(AppConfig.class) // This will include Appconfig Config also so we use Parentconfig to create ApplicationContext
class ParentConfig {

  @Bean
  public A getA() {
    return new A();
  }
}

