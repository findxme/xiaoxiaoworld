package com.xmx.ssm.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class User {
    private int id;
    private String userType;
    private String userName;
    private String password;
    private String email;
    private String mobile;
    private String address;
    private String city;
}
