package com.zzg.mybatis.generator.controller;

import com.zzg.mybatis.generator.model.User;
import com.zzg.mybatis.generator.model.UserExample;
import com.zzg.mybatis.generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By dengq
 * 14:08 2019/5/7
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findByUser")
    @ResponseBody
    public List<User> findByUser(UserExample example){
        List<User> users = userService.selectByExample(example);
        return users;
    }

    @RequestMapping("findAll")
    @ResponseBody
    public Map<String ,Object > finAll(Integer id){
        Map<String , Object> map = new HashMap<>();
        User user = userService.selectByPrimaryKey(id);
        map.put("user",user);
        return map;
    }
}
