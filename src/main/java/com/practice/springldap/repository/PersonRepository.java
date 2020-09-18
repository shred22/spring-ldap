package com.practice.springldap.repository;

import com.practice.springldap.entry.User;
import org.springframework.data.ldap.repository.LdapRepository;

import java.util.List;

public interface PersonRepository extends LdapRepository<User> {

    List<User> findByUserName(String userName);
    // additional custom finder methods go here
}