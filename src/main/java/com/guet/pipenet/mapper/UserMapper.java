package com.guet.pipenet.mapper;

import com.guet.pipenet.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper
{
    User selectByAccount(String account);

    boolean insertAccount(User user);
}
