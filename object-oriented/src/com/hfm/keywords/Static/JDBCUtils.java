package com.hfm.keywords.Static;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hfm
 * @version 1.01 2020-04-04 12:00
 * @date 2020/4/4
 */
public class JDBCUtils {
    private static DataSource dataSource = null;

    static {
        InputStream is = null;
        try {
        //    is = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
            Properties pros = new Properties();
            pros.load(is);
            //调用BasicDataSourceFactory的静态方法，获取数据源。
       //     dataSource = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用DBCP数据库连接池实现数据库的连接
    public static Connection getConnection2() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        return conn;
    }
}
