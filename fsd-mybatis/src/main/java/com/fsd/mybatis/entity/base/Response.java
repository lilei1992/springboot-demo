package com.fsd.mybatis.entity.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private T data;

    private Integer total;

    private Integer pageNum;

    private Integer pageSize;

}
