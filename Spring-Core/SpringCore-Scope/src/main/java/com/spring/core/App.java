package com.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.core.annotationbased.config.PrototypeUserService_anno;
import com.spring.core.annotationbased.config.SingletionUserService_anno;
import com.spring.core.javabased.config.PrototypeUserService;
import com.spring.core.javabased.config.SingletionUserService;

/**
 * ci - Constructor Injection
 * 
 * si - Setter Injection
 *
 */
public class App {

  public static void main(String[] args) {
    // Java Based
    System.out.println("\nJava based");
    AnnotationConfigApplicationContext appctx =
        new AnnotationConfigApplicationContext(AppConfig_javabased.class);
    /**
     * only a single instance per Spring IoC container, no matter how many time you retrieve it with
     * getBean(), it will always return the same instance.
     */
    SingletionUserService singleton = appctx.getBean(SingletionUserService.class);
    singleton.setName("Singleton");
    singleton.print();

    SingletionUserService singleton1 = appctx.getBean(SingletionUserService.class);
    // System.out.println(singleton1.getName());
    singleton1.print();



    /*
     * Prototype - scope
     * 
     * you will have a new instance for each getBean() method called.
     */

    PrototypeUserService protoType = appctx.getBean(PrototypeUserService.class);
    protoType.setName("Prototype");
    protoType.print();

    PrototypeUserService protoType1 = appctx.getBean(PrototypeUserService.class);
    System.out.println(protoType1.getName());
    appctx.close();



    System.out.println("\nAnnotation based");

    // Java Based
    AnnotationConfigApplicationContext appctx1 =
        new AnnotationConfigApplicationContext(AppConfig_annobased.class);
    /**
     * only a single instance per Spring IoC container, no matter how many time you retrieve it with
     * getBean(), it will always return the same instance.
     */
    SingletionUserService_anno singleton_anno1 = appctx1.getBean(SingletionUserService_anno.class);
    singleton_anno1.setName("Singleton Anno");
    singleton_anno1.print();

    SingletionUserService_anno singleton_anno2 = appctx1.getBean(SingletionUserService_anno.class);
    // System.out.println(singleton1.getName());
    singleton_anno2.print();



    /*
     * Prototype - scope
     * 
     * you will have a new instance for each getBean() method called.
     */

    PrototypeUserService_anno protoType_anno1 = appctx1.getBean(PrototypeUserService_anno.class);
    protoType_anno1.setName("Prototype Anno");
    protoType_anno1.print();

    PrototypeUserService_anno protoType_anno2 = appctx1.getBean(PrototypeUserService_anno.class);
    System.out.println(protoType_anno2.getName());
    appctx1.close();
  }
}
