package com.practice.springldap.entry;

import javax.naming.Name;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
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

  @Attribute(name = "uid")
  @DnAttribute(value="uid", index=3)
  private String uid;

  @Attribute(name = "ou")
  @DnAttribute(value="ou", index=2)
  private String orgUnit;

  @Attribute(name = "sn")
  private String lastName;

  @Attribute(name = "userPassword")
  private String userPassword;


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

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getOrgUnit() {
    return orgUnit;
  }

  public void setOrgUnit(String orgUnit) {
    this.orgUnit = orgUnit;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  @Override
  public String toString() {
    return "User{" +
            "dn=" + dn +
            ", userName='" + userName + '\'' +
            ", uid='" + uid + '\'' +
            ", orgUnit='" + orgUnit + '\'' +
            ", lastName='" + lastName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            '}';
  }
}
