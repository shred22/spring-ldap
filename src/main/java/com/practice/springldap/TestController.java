package com.practice.springldap;

import com.practice.springldap.repository.LdapTemplateImpl;
import com.practice.springldap.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    LdapTemplateImpl ldapTemplate;

    @GetMapping(value = "/testGet")
    public String get() {

        ldapTemplate.lookup();

        ldapTemplate.lookupFromLdapRepo();
        return "done";

    }
}
