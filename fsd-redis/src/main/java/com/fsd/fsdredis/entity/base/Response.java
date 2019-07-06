package com.fsd.fsdredis.entity.base;

import com.fsd.fsdredis.entity.BaseObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> extends BaseObject {
    @ApiModelProperty(value="提示信息")
    private String msg;
    @ApiModelProperty(value="错误码")
    private int code;
    @ApiModelProperty(value="对象模型",required = true)
    private T data;
}
