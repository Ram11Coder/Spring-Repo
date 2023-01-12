package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.core.ci.ConstructorInjection;
import com.spring.core.si.SetterBasedInjection;

/**
 * ci - Constructor Injection
 * 
 * si - Setter Injection
 *
 */
public class App {

  public static void main(String[] args) {
    // Constructor injection
    AnnotationConfigApplicationContext appctx =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ConstructorInjection ci = appctx.getBean(ConstructorInjection.class);
    ci.processMessage("Twitting my first message:)");

    appctx.close();
    // Setter Injection
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    SetterBasedInjection setterBasedInjection =
        applicationContext.getBean(SetterBasedInjection.class);
    setterBasedInjection.processMsg("twitter my second message ");
  }
}
