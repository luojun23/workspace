package com.njtech.builder;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.njtech.utils.PropertiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataSource;
import java.sql.*;

public class buildTable {
    private static final Logger logger = LoggerFactory.getLogger(buildTable.class);
    private static String select_table = "show table status";
    private static Connection connection = null;
    static {
        try {
            Class.forName(PropertiUtils.getName("spring.datasource.driver-class-name"));
        } catch (ClassNotFoundException e) {
            logger.error("",e);
        }
        String url = PropertiUtils.getName("spring.datasource.url");
        String username = PropertiUtils.getName("spring.datasource.username");
        String password = PropertiUtils.getName("spring.datasource.password");

        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            logger.error("数据库连接失败",e);
        }
    }

    public static void getTable()
    {
        PreparedStatement ps = null;
        ResultSet ret = null;
        try {
            ps =  connection.prepareStatement(select_table);
            ret =ps.executeQuery();
            while(ret.next()){
                String name = ret.getString("Name");
                String comment = ret.getString("Comment");
                logger.info("tableName:{},comment:{}",name,comment);
            }
        } catch (Exception e) {
            logger.error("查询异常",e);
        }
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ret.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
