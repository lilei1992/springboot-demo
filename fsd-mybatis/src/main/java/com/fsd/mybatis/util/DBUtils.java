package com.fsd.mybatis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * created by lilei
 * since 2019/7/6
 **/
public class DBUtils {

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Properties pros = new Properties();
            pros.setProperty("user", "root"); // 设置Properties对象属性
            pros.setProperty("password", "123456");
            Class.forName("com.mysql.jdbc.Driver"); // 注册数据库驱动
            String url = "jdbc:mysql://localhost:3306/mall?serverTimezone=GMT"; // mall为数据库名称
            connection = DriverManager.getConnection(url, pros); // 获取连接数据库的Connection对象
            System.out.println("数据库连接成功！" + connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }



}
