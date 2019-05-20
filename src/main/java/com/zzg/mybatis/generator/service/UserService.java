package com.zzg.mybatis.generator.service;

import com.zzg.mybatis.generator.model.User;
import com.zzg.mybatis.generator.model.UserExample;

import java.util.List;

/**
 * Created By dengq
 * 13:58 2019/5/7
 */
public interface UserService {
    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);
}
