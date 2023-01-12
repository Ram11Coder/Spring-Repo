package com.spring.core.ci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjection {

  private MessageService service;

  @Autowired
  public ConstructorInjection(@Qualifier("TwitterService") MessageService service) {
    super();
    this.service = service;
  }

  /*
   * public MessageService getService() { return service; }
   * 
   * public void setService(MessageService service) { this.service = service; }
   */

  public void processMessage(String message) {
    service.sendMessage(message);
  }



}
