package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.spring.core.javabased.config.PrototypeUserService;
import com.spring.core.javabased.config.SingletionUserService;

@Configuration
@ComponentScan(basePackages = "com.spring.core.javabased.config")
public class AppConfig_javabased {

  // If no bean scope is specified in bean configuration file, default to a singleton
  @Bean
  public SingletionUserService singleton() {
    return new SingletionUserService();
  }

  @Bean
  @Scope("prototype")
  public PrototypeUserService protoType() {
    return new PrototypeUserService();
  }
}
