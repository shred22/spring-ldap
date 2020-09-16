package com.practice.springldap.repository;

import com.practice.springldap.entry.User;
import org.springframework.data.ldap.repository.LdapRepository;

public interface PersonRepository extends LdapRepository<User> {

    // additional custom finder methods go here
}