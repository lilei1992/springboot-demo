package com.fsd.mybatis.entity.base;

import lombok.Data;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Data
public class Reqeust<T> {

    private T data;

    private Integer pageNum;

    private Integer pageSize;
}
