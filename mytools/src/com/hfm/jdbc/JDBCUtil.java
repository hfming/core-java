package com.hfm.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC连接数据库
 * 
 * @author 26554
 */
public class JDBCUtil {
	/**
	 * 连接数据库，获取数据库连接对象
	 * @return
	 */
	public static Connection getConnect() {
		Connection connection = null;
		Properties properties = null;
		FileInputStream inStream = null;
		try {
			properties =new Properties();
			inStream = new FileInputStream("C:/MyEclipseWorkspaces/learningDay0043/jdbc.properties");
			properties.load(inStream);
			String classname = properties.getProperty("class");
			Class.forName(classname);
			// 2.通过DriverManager.getConnection()方法，填写url与用户名及密码获取数据库连接对象
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			// jdbc关键字:mysql数据库名称：//IP地址：端口号/使用的数据库名称
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}catch(FileNotFoundException e){
			throw new RuntimeException(e);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	/**
	 * 关闭资源
	 * 
	 * @param connection
	 * @param statement
	 */
	public static void close(Connection connection, Statement statement) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
