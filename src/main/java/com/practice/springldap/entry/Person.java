package com.practice.springldap.entry;

import org.springframework.ldap.odm.annotations.*;

import javax.naming.Name;

@Entry(objectClasses = { "person", "top", "organizationalPerson", "inetOrgPerson" }, base="ou=people")
public class Person {

   @Id
   private Name dn;

   @Attribute(name="cn")
   @DnAttribute(value="cn", index=1)
   private String fullName;

   @Attribute(name="firstName")
   private String firstName;

   @DnAttribute(value="ou", index=0)
   @Transient
   private String company;

   @Transient
   private String someUnmappedField;
   // ...more attributes below
}