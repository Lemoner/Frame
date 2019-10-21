package com.lmr.springboot.service;

import com.lmr.springboot.dao.UserMapper;
import com.lmr.springboot.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lemonlimengran@didichuxing.com
 * @date 2019-10-21
 * @description
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryAllUser() {
        List<User> list;
        list = userMapper.selectAll();
        return list;
    }

}
