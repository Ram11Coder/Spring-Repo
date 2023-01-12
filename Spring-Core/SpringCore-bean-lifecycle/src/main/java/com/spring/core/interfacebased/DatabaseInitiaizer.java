package com.spring.core.interfacebased;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import com.spring.core.User;

@Component
public class DatabaseInitiaizer implements InitializingBean, DisposableBean {

  private List<User> listOfUsers = new ArrayList<>();

  // it will run afterPropertiesSet() after all bean properties have been set.
  @Override
  public void afterPropertiesSet() throws Exception {
    User user = new User(1, "User");
    User user1 = new User(2, "Admin");
    User user2 = new User(3, "SuperAdmin");

    listOfUsers.add(user);
    listOfUsers.add(user1);
    listOfUsers.add(user2);
    System.out.println("-----------List of users added in init() method ------------");
    for (Iterator<User> iterator = listOfUsers.iterator(); iterator.hasNext();) {
      System.out.println(iterator.next().toString());
    }
    // save to database
  }


  // it will run destroy() after Spring container is released the bean.
  @Override
  public void destroy() {
    // Delete from database
    listOfUsers.clear();
    System.out
        .println("-----------After of users removed from List in destroy() method ------------");
    for (Iterator<User> iterator = listOfUsers.iterator(); iterator.hasNext();) {
      System.out.println(iterator.next().toString());

    }
    System.out.println("List is clean up ..");
  }
}
