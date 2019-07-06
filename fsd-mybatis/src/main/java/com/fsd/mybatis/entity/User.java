package com.fsd.mybatis.entity;

import com.fsd.mybatis.entity.base.BasePage;
import lombok.Data;

import java.io.Serializable;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Data
public class User extends BasePage implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;

}
