package com.practice.springldap;

import com.practice.springldap.entry.User;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.ldap.core.LdapTemplate;

@SpringBootApplication
public class SpringLdapApplication {

  public static void main(String[] args) {
    final ConfigurableApplicationContext context = SpringApplication
        .run(SpringLdapApplication.class, args);

    LdapTemplate ldapTemplate = context.getBean("ldapTemplate", LdapTemplate.class);

    List<User> all = ldapTemplate.findAll(User.class);

    System.out.println(all);
  }
}
