package com.guet.pipenet.service;

import com.guet.pipenet.entity.User;

import reactor.util.annotation.Nullable;

public interface UserService
{
    User getUserByAccount(String account) throws Exception;

    /*
    * @return id
    * 登录，成功返回id，失败返回null
    *
    * */
    @Nullable
    Long login(String account, String password) throws Exception;

    boolean createUser(String account, String password) throws Exception;
}
