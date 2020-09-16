package com.practice.springldap.entry;

import javax.naming.Name;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(
    objectClasses = "person"
)
public class User {

  @Id
  private Name dn;
  @Attribute(name = "cn")
  private String userName;

  public Name getDn() {
    return dn;
  }

  public void setDn(Name dn) {
    this.dn = dn;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public String toString() {
    return "User{" +
        "dn=" + dn +
        ", userName='" + userName + '\'' +
        '}';
  }
}
