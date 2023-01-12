package com.spring.core.ci;

import org.springframework.stereotype.Component;

@Component
public class SMSService implements MessageService {
  @Override
  public void sendMessage(String message) {
    System.out.println("Sms Service : " + message);

  }
}
