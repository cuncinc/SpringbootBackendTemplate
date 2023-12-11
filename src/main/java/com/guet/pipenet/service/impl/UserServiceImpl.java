package com.guet.pipenet.service.impl;

import com.guet.pipenet.entity.User;
import com.guet.pipenet.mapper.UserMapper;
import com.guet.pipenet.service.UserService;
import com.guet.pipenet.utils.CryptoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByAccount(String account) throws Exception
    {
        return userMapper.selectByAccount(account);
    }

    @Override
    public Long login(String account, String password) throws Exception
    {
        User user = getUserByAccount(account);
        log.info("userId", user.getUserId());

        if (user != null)
        {
            if (CryptoUtil.checkPassword(password, user.getPassword()))
            {
                return user.getUserId();
            }
        }
        return null;
    }

    @Override
    public boolean createUser(String account, String password) throws Exception
    {
        User user = new User(account, CryptoUtil.hashPassword(password));
        if (userMapper.insertAccount(user))
        {
            return true;
        }
        return false;
    }
}
