package com.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */

public class AppTest {

  @Test
  public void givenBeanComponents_whenSearchingInApplicationContext_thenFindThem() {
    ApplicationContext appctx = new AnnotationConfigApplicationContext(AppConfig.class);

    Assertions.assertNotNull(appctx.getBean(BeanExample.class));
  }
}
