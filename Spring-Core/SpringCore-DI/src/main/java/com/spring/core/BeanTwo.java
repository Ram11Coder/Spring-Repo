package com.spring.core;

import org.springframework.stereotype.Component;

@Component
public class BeanTwo {
  private String msg;

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public void print() {
    System.out.println(msg);
  }
}
