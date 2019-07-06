package com.fsd.fsdredis.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Data
public class BaseObject {
    @ApiModelProperty(value="key值")
    private String key;
    @ApiModelProperty(value="value值")
    private String vlaue;

}
