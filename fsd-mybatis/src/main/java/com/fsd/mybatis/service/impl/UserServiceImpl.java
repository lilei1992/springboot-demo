package com.fsd.mybatis.service.impl;

import com.fsd.mybatis.entity.User;
import com.fsd.mybatis.mapper.UserMapper;
import com.fsd.mybatis.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> queryUser(int pageNum,int pageSize) {
        Page<User> page = PageHelper.startPage(pageNum,pageSize);
        userMapper.queryUser();
        return page;
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }


}
