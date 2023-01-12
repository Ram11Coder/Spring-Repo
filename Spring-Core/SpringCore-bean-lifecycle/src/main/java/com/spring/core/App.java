package com.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring container management: interact with the container’s management of the bean lifecycle, you
 * can implement the Spring InitializingBean and DisposableBean interfaces. The container calls
 * afterPropertiesSet() for the former and destroy() for the latter to let the bean perform certain
 * actions upon initialization and destruction of your beans.
 *
 *
 *
 * 1. For bean implemented InitializingBean, it will run afterPropertiesSet() after all bean
 * properties have been set.
 *
 * 2. For bean implemented DisposableBean, it will run destroy() after Spring container is released
 * the bean.
 */
public class App {

  public static void main(String[] args) {
    /*
     * AnnotationConfigApplicationContext appctx = new
     * AnnotationConfigApplicationContext(AppConfig.class); appctx.close();
     */

    // Using Bean Annotation
    AnnotationConfigApplicationContext appctx1 =
        new AnnotationConfigApplicationContext(AppConfig_anno.class);
    appctx1.close();

    // Using 3rd Part annotation
    /**
     * <dependency> <groupId>javax.annotation</groupId>
     * <artifactId>javax.annotation-api</artifactId> <version>1.3.2</version> </dependency>
     */

    AnnotationConfigApplicationContext appctx2 =
        new AnnotationConfigApplicationContext(AppConfig_3rdParty.class);
    appctx2.close();
  }
}
