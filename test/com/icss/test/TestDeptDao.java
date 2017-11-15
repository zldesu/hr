package com.icss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * ���Բ��ŷ��ʹ���
 * @author DLETC
 *
 */
public class TestDeptDao {
	private DeptDao dao = new DeptDao(); 
	@Test
	public void testInsert() throws SQLException {
//		int i = 1 + 1;
//		System.out.println("i = " + i);
//		
//		Assert.assertEquals(3, i);
		
		Dept dept = new Dept("������","����");
		dao.insert(dept);
		
	}
	
	@Test
	public void testUpdae() throws SQLException {
		Dept dept = new Dept(1,"���ز�","����");
		dao.update(dept);
	}
	
	@Test
	public void testDelete() throws SQLException {
		
		dao.delete(7);
	}
	
	@Test
	public void testSelect() throws SQLException {
		Dept dept = dao.queryById(111);
		System.out.println(dept);
	}
	
	@Test
	public void testQuery() throws SQLException {
		List<Dept> list = dao.query();
		for(Dept d : list){
			System.out.println(d);
		}
	}
	
	
}
