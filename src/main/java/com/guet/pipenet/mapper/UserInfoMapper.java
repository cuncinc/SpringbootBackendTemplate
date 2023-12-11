package com.guet.pipenet.mapper;

import com.guet.pipenet.entity.UserInfo;

import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Mapper;

@Component
@Mapper
public interface UserInfoMapper
{

    UserInfo selectByPrimaryKey(Integer id);

}