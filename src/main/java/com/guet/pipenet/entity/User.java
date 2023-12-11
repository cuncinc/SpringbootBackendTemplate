package com.guet.pipenet.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User
{
    public User()
    {
    }

    public User(String account, String password)
    {
        this.account = account;
        this.password = password;
    }

    private Long userId;
    private String account;
    private String realName;
    private String email;
    private Long departmentId;
    private String phone;
    private String sex;
    private String avatar;
    private String jobPosition;
    private String password;
}
