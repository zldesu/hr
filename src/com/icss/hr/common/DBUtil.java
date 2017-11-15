package com.icss.hr.common;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接工具类
 * @author DLETC
 */
public class DBUtil {
	
	//数据源对象
	private static ComboPooledDataSource dataSource;
	
	//本地线程对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	//设置连接池参数
	static {
		dataSource = new ComboPooledDataSource();
		
		try {
			//数据库链接相关参数
			dataSource.setUser("myhr");
			dataSource.setPassword("myhr");
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			
			//连接池相关参数
			dataSource.setInitialPoolSize(10);//初始连接数
			dataSource.setMaxPoolSize(20);//最大连接数
			dataSource.setMinPoolSize(10); //最小连接数
			dataSource.setMaxIdleTime(60);//最大空闲时间60秒，连接对象60秒内没有被使用才会被销毁
			
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过连接池对象返回数据库连接
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		//从本地取连接对象
		Connection conn = threadLocal.get();
		//把当前取出的链接对象先放到本地线程
		if(conn == null || conn.isClosed()) {
			conn = dataSource.getConnection();
			threadLocal.set(conn);
		}
		//测试语句，返回空闲链接
		System.out.println("获得数据库链接，剩余空闲链接:" + dataSource.getNumIdleConnections());
		return conn;
	}
	/**
	 * 统一关闭连接方法
	 */
	public static void close() {
		//从本地线程中取出链接
		Connection conn = threadLocal.get();
		
		try {
			if (conn != null && !conn.isClosed()) {
				//关闭链接
				conn.close();
				//解除存储
				threadLocal.set(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
