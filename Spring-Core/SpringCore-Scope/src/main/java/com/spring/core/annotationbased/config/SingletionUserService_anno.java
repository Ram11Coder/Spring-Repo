package com.spring.core.annotationbased.config;

import org.springframework.stereotype.Service;

@Service
public class SingletionUserService_anno {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void print() {
    System.out.println(name);
  }
}
