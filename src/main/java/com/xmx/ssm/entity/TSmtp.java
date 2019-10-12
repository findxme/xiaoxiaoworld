package com.xmx.ssm.entity;

public class TSmtp {

  private String email;
  private String smtp;
  private String name;
  private String password;
  private long prot;


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getSmtp() {
    return smtp;
  }

  public void setSmtp(String smtp) {
    this.smtp = smtp;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getProt() {
    return prot;
  }

  public void setProt(long prot) {
    this.prot = prot;
  }

}
