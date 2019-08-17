package com.fsd.mybatis.service.impl;


import com.fsd.mybatis.entity.User;
import com.fsd.mybatis.mapper.UserMapper;
import com.fsd.mybatis.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

/**
 * created by lilei
 * since 2019/7/21
 **/
public class UserServiceImplNotAuto implements UserService {

    private final TransactionTemplate transactionTemplate;

    @Autowired
    private UserMapper userMapper;


    public UserServiceImplNotAuto(PlatformTransactionManager transactionManager) {
        Assert.notNull(transactionManager, "The 'transactionManager' argument must not be null.");
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }


    @Override
    public Page<User> queryUser(final int pageNum, int pageSize) {
        return transactionTemplate.execute(new TransactionCallback<Page<User>>() {
            @Override
            public Page<User> doInTransaction(TransactionStatus transactionStatus) {
                Page<User> page = PageHelper.startPage(pageNum, pageSize);
                userMapper.queryUser();
                return page;
            }
        });

    }

    public Object queryUser1(int pageNum, int pageSize) {
        return transactionTemplate.execute((t) -> {
            return new Object();  //执行逻辑
        });
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }
}
