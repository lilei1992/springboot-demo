package com.fsd.mybatis.mapper;

import com.fsd.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Mapper
public interface UserMapper {

    List<User> queryUser();

   User getUserById(Long id);
}
