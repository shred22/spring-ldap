package com.practice.springldap.repository;

import com.practice.springldap.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;


@Service
public class LdapTemplateImpl {

    @Autowired
    private LdapTemplate ldapTemplate;
    @Autowired
    private PersonRepository personRepository;
    @Value("${spring.ldap.embedded.base-dn}")
    private String baseDn;

    public void lookup() {
        List<String> search = ldapTemplate.search(
                query().where("objectclass").is("person"),
                (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());

        search.forEach(cn -> System.out.println("CN is : " + cn));

        List<String> search1 = ldapTemplate.search(query().where("cn").is("Bob Hamilton"),
                (AttributesMapper<String>) attrs -> (String) attrs.get("uid").get());
        search1.forEach(uid -> System.out.println("\n\n\n\nUID  is : " + uid));
        String lookup = ldapTemplate.lookup("uid=bob,ou=people,dc=springframework,dc=org",
                (AttributesMapper<String>) attrs -> (String) attrs.get("uid").get());

        System.out.println("\n\n\nlokup is: " + lookup);


    }
    public void lookupFromLdapRepo() {

        Iterable<User> all = personRepository.findAll(query().where("cn").is("Joe Smeth"));

        all.forEach(person -> {
            System.out.println("LDAP Repo : " + person);

        });
        System.out.println("\n\n\n\n\n\n Users by name");
        System.out.println(personRepository.findByUserName("Bob Hamilton"));


    }

}
