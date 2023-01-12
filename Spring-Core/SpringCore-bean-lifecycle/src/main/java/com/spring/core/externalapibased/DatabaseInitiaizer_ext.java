package com.spring.core.externalapibased;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import com.spring.core.User;

@Component
public class DatabaseInitiaizer_ext {

  private List<User> listOfUsers = new ArrayList<>();


  @PostConstruct
  public void init() {
    User user = new User(1, "User");
    User user1 = new User(2, "Admin");
    User user2 = new User(3, "SuperAdmin");

    listOfUsers.add(user);
    listOfUsers.add(user1);
    listOfUsers.add(user2);
    System.out.println("-----------List of users added in init() method ------------");
    for (Iterator<User> iterator = listOfUsers.iterator(); iterator.hasNext();) {
      User user3 = (User) iterator.next();
      System.out.println(user3.toString());
    }
    // save to database

  }


  @PreDestroy
  public void destroy() {
    // Delete from database
    listOfUsers.clear();
    System.out
        .println("-----------After of users removed from List in destroy() method ------------");
    for (Iterator<User> iterator = listOfUsers.iterator(); iterator.hasNext();) {
      User user3 = (User) iterator.next();
      System.out.println(user3.toString());
    }
    System.out.println("End of destroy()  method");
  }
}
