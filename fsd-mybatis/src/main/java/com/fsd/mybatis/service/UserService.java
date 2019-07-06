package com.fsd.mybatis.service;

import com.fsd.mybatis.entity.User;
import com.github.pagehelper.Page;

/**
 * created by lilei
 * since 2019/7/6
 **/
public interface UserService {

    Page<User> queryUser(int page, int pageSize);

    User getUserById(Long id);
}
