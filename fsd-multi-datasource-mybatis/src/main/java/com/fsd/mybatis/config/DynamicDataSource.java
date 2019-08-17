package com.fsd.mybatis.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * created by lilei
 * since 2019/7/7
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
            System.out.println("数据源为" + DataSourceContextHolder.getDB());
            return DataSourceContextHolder.getDB();
        }
    }
