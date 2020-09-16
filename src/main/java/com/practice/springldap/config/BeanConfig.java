package com.practice.springldap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class BeanConfig {

  @Bean
  ContextSource contextSource() {
    LdapContextSource ldapContextSource = new LdapContextSource();
    ldapContextSource.setUrl("ldap://localhost:8389");

    return ldapContextSource;
  }

  @Bean
  LdapTemplate ldapTemplate(ContextSource contextSource) {
    return new LdapTemplate(contextSource);
  }
}
