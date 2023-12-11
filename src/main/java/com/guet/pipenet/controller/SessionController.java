package com.guet.pipenet.controller;

import com.guet.pipenet.mapper.UserMapper;
import com.guet.pipenet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/")
public class SessionController
{
    @Autowired
    private UserService userService;

    @PostMapping("/sessions")
    public String login(@RequestBody Map<String, String> req) throws Exception
    {
        String account = req.get("account");
        String password = req.get("password");

        log.info("account " + account);
        Long userId = userService.login(account, password);
        log.info("userId " + userId);

        if (null != userId)
        {
            StpUtil.login(userId);
            return "{\"code\":201}";
        }

        return "{\"code\":400}";
    }

    @GetMapping("/check")
    public String check()
    {
        String token = StpUtil.getTokenValue();
        String id = (String) StpUtil.getLoginIdByToken(token);
        return "{\"token\":" + token + ",\"id\"" + id + "}";
    }
}
