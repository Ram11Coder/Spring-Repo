package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanOne {

  // @Autowired
  private BeanTwo beanTwo;


  public BeanTwo getBeanTwo() {
    return beanTwo;
  }

  @Autowired //Setter Based injection
  public void setBeanTwo(BeanTwo beanTwo) {
    this.beanTwo = beanTwo;
  }

  public void print() {
    beanTwo.setMsg("Hello World");
    beanTwo.print();
  }
}
