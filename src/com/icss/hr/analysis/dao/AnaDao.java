package com.icss.hr.analysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.icss.hr.common.DBUtil;

/**
 * ���ݷ���dao
 * @author DLETC
 *
 */
public class AnaDao {
	/**
	 * ͳ��ÿ�����ŵ�����
	 * @throws SQLException 
	 */
	
	public List<HashMap<String,Object>> queryEmpCount() throws SQLException {
			Connection conn = DBUtil.getConnection();
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT dept_name,COUNT(emp_id) AS counts ");
			sql.append("FROM   emp e ");
			sql.append("RIGHT  OUTER JOIN dept d ON d.dept_id = e.emp_dept_id ");
			sql.append("GROUP  BY dept_name");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			List<HashMap<String,Object>> list = new ArrayList<>();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("deptName", rs.getString(1));
				map.put("counts", rs.getInt(2));
				list.add(map);
			}
			return list;
	}
	
	/**
	 * ��ѯÿ�����ŵ�ƽ������
	 */
	public List<HashMap<String,Object>> queryEmpAvgSal() throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT dept_name,avg(emp_salary) AS avg_sal ");
		sql.append("FROM   emp e ");
		sql.append("RIGHT  OUTER JOIN dept d ON d.dept_id = e.emp_dept_id ");
		sql.append("GROUP  BY dept_name");
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		
		List<HashMap<String,Object>> list = new ArrayList<>();
		
		while(rs.next()) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("deptName", rs.getString(1));
			map.put("avgSal", rs.getDouble(2));
			list.add(map);
		}
		return list;
	}
	
	/**
	 * ��ѯ���ŵ������͹���
	 */
	public List<HashMap<String,Object>> queryEmpMaxAndMinSal() throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT d.dept_name,MAX(emp_salary) max_sal,MIN(emp_salary) min_sal  ");
		sql.append("FROM   emp e ");
		sql.append("RIGHT  OUTER JOIN dept d ON d.dept_id = e.emp_dept_id ");
		sql.append("GROUP  BY d.dept_name");
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		
		List<HashMap<String,Object>> list = new ArrayList<>();
		
		while(rs.next()) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("deptName", rs.getString(1));
			map.put("MaxSal", rs.getInt(2));
			map.put("MinSal", rs.getInt(3));
			list.add(map);
		}
		return list;
	}
	
	
}
