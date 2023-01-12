package com.spring.core.si;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.spring.core.ci.MessageService;

@Component
public class SetterBasedInjection {
  private MessageService messageService;

  @Autowired
  @Qualifier("TwitterService")
  public void setMessageService(MessageService messageService) {
    this.messageService = messageService;
  }

  public void processMsg(String message) {
    messageService.sendMessage(message);
  }
}
