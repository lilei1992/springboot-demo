package com.fsd.fsdredis.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Data
public class User {

    @ApiModelProperty(value="姓名",example = "姓名",required = true)
    private String name;
    @ApiModelProperty(value="年龄")
    private int age;
    @ApiModelProperty(value="密码")
    private String password;

}
