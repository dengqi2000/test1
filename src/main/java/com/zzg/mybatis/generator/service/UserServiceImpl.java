package com.zzg.mybatis.generator.service;

import com.zzg.mybatis.generator.mapper.UserMapper;
import com.zzg.mybatis.generator.model.User;
import com.zzg.mybatis.generator.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * Created By dengq
 * 13:58 2019/5/7
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
