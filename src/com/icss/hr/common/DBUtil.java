package com.icss.hr.common;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ����ӹ�����
 * @author DLETC
 */
public class DBUtil {
	
	//����Դ����
	private static ComboPooledDataSource dataSource;
	
	//�����̶߳���
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	//�������ӳز���
	static {
		dataSource = new ComboPooledDataSource();
		
		try {
			//���ݿ�������ز���
			dataSource.setUser("myhr");
			dataSource.setPassword("myhr");
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			
			//���ӳ���ز���
			dataSource.setInitialPoolSize(10);//��ʼ������
			dataSource.setMaxPoolSize(20);//���������
			dataSource.setMinPoolSize(10); //��С������
			dataSource.setMaxIdleTime(60);//������ʱ��60�룬���Ӷ���60����û�б�ʹ�òŻᱻ����
			
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ͨ�����ӳض��󷵻����ݿ�����
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		//�ӱ���ȡ���Ӷ���
		Connection conn = threadLocal.get();
		//�ѵ�ǰȡ�������Ӷ����ȷŵ������߳�
		if(conn == null || conn.isClosed()) {
			conn = dataSource.getConnection();
			threadLocal.set(conn);
		}
		//������䣬���ؿ�������
		System.out.println("������ݿ����ӣ�ʣ���������:" + dataSource.getNumIdleConnections());
		return conn;
	}
	/**
	 * ͳһ�ر����ӷ���
	 */
	public static void close() {
		//�ӱ����߳���ȡ������
		Connection conn = threadLocal.get();
		
		try {
			if (conn != null && !conn.isClosed()) {
				//�ر�����
				conn.close();
				//����洢
				threadLocal.set(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
