package com.spring.core.ci;

import org.springframework.stereotype.Component;

@Component("TwitterService")
public class TwitterService implements MessageService {

  @Override
  public void sendMessage(String message) {
    System.out.println("Twitter Service : " + message);
  }

}
