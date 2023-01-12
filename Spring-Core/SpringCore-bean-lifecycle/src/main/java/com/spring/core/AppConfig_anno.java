package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.spring.core.annotationbased.DatabaseInitiaizer_anno;

@Configuration
@ComponentScan(basePackages = "com.spring.core.annotationbased")
public class AppConfig_anno {

  @Bean(initMethod = "init", destroyMethod = "destroy")
  public DatabaseInitiaizer_anno databaseInitiaizer() {
    return new DatabaseInitiaizer_anno();
  }
}
