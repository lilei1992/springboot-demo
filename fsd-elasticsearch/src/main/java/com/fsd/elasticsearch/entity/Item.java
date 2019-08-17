package com.fsd.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * created by lilei
 * since 2019/8/4
 **/

// indexName索引名称 可以理解为数据库名 必须为小写,
//                          不然会报org.elasticsearch.indices.InvalidIndexNameException异常
// type类型 可以理解为表名
@Data
@AllArgsConstructor
@Document(indexName = "item", type = "docs", shards = 1, replicas = 0)
public class Item {
    /**
     * 注: 该注解是必填项
     * @Description: @Id注解必须是springframework包下的
     * org.springframework.data.annotation.Id
     * @Author: https://blog.csdn.net/chen_2890
     */
    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title; //标题

    @Field(type = FieldType.Keyword)
    private String category;// 分类

    @Field(type = FieldType.Keyword)
    private String brand; // 品牌

    @Field(type = FieldType.Double)
    private Double price; // 价格

    @Field(index = false, type = FieldType.Keyword)
    private String images; // 图片地址

}
