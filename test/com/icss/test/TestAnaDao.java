package com.icss.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.icss.hr.analysis.dao.AnaDao;

/**
 * 测试数据分析
 * @author DLETC
 */

public class TestAnaDao {
	private AnaDao dao = new AnaDao();
	@Test
	public void test() {
		HashMap<String, Object> map1= new HashMap<>();
		map1.put("deptName", "会计分部");
		map1.put("empCount", 5);
		
		HashMap<String, Object> map2= new HashMap<>();
		map1.put("deptName", "公关部");
		map1.put("empCount", 5);
		
		HashMap<String, Object> map3= new HashMap<>();
		map1.put("deptName", "测试部");
		map1.put("empCount", 5);
		
		ArrayList<HashMap<String,Object>> list = new ArrayList<>(); 
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		System.out.println(list);
	}
	@Test
	public void testQEC() throws SQLException {
		List<HashMap<String, Object>> list = dao.queryEmpCount();
		System.out.println(list);
	}
	
	@Test
	public void testQAS() throws SQLException {
		List<HashMap<String, Object>> list = dao.queryEmpAvgSal();
		System.out.println(list);
	}
	@Test
	public void testQEMMS() throws SQLException {
		List<HashMap<String, Object>> list = dao.queryEmpMaxAndMinSal();
		System.out.println(list);
	}
	
	
}
