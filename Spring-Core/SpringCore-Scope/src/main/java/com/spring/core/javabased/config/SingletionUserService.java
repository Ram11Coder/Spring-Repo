package com.spring.core.javabased.config;

public class SingletionUserService {
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