package com.zpy.springboottest.model;

import lombok.Data;

@Data
public class UserDomain {

    private Integer userId;

    private String userName;

    private String password;

    private String phone;
}
