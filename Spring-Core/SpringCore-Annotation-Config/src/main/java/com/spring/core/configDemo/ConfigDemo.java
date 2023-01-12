package com.spring.core.configDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

class Dummy {
}


@Configuration
@PropertySource("classpath:config.properties") // calling config.property file from class path
public class ConfigDemo {


  @Autowired
  private Environment env;

  @Bean
  public Dummy d() {
    System.out.println(" test.value : " + env.getProperty("test.value"));
    return new Dummy();
  }
}
