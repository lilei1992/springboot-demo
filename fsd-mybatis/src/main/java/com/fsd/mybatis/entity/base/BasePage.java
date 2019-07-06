package com.fsd.mybatis.entity.base;

import lombok.Data;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Data
public class BasePage {

    private Integer page;

    private Integer pageSize;

    private Integer total;

}
