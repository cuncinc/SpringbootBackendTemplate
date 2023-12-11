package com.guet.pipenet.controller;

import com.guet.pipenet.mapper.UserMapper;
import com.guet.pipenet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/users")
    public String createUser(@RequestBody Map<String, String> req) throws Exception
    {
        String account = req.get("account");
        String password = req.get("password");

        // 账号是否已经存在
        if (userMapper.selectByAccount(account) != null)
        {
            return "{\"code\":403}";
        }

        if (userService.createUser(account, password))
        {
            return "{\"code\":201}";
        }
        return "{\"code\":400}";
    }
}
