package com.icss.test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.common.Page;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;

/**
 * 员工dao测试
 * @author DLETC
 *
 */
public class TestEmpDao {
	
	@Test
	public void testInsert() throws SQLException {
		Dept dept = new Dept();
		dept.setDeptId(1);
		
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp("Timmy","Timmy","123456","tom@163.com","13568746687",3600,Date.valueOf("1995-03-18"),null,"精通java、oracle",dept,job);
		
		EmpDao ed = new EmpDao();
		
		ed.insert(emp);
	}
	
	@Test
	public void update() throws SQLException {
		Dept dept = new Dept();
		dept.setDeptId(1);
		
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp(12,"Tommy","Tommy","123456","tom@163.com","13568746687",3600,Date.valueOf("1995-03-18"),null,"精通java、oracle",dept,job);
		EmpDao ed =new EmpDao();
		ed.update(emp);
		
	}
	
	@Test
	public void queryById () throws SQLException {
		EmpDao ed =new EmpDao();
		ed.queryById(12);
	}
	
	@Test
	public void login() throws SQLException {
		EmpDao ed =new EmpDao();
		ed.queryByLoginName("Rose");
		System.out.println(ed.queryByLoginName("Rose"));
	}
	
	@Test
	public void delete() throws SQLException {
		EmpDao ed =new EmpDao();
		ed.delete(16);
	}
	
	
	@Test
	public void testInsertManay() throws SQLException {
		Dept dept = new Dept();
		dept.setDeptId(1);
		
		Job job = new Job();
		job.setJobId(1);
		
		EmpDao ed = null;
		Emp emp = null;
		for(int i = 41;i < 60;i ++) {
			emp = new Emp("Timmy" + i,"Timmy" + i,"123456","tom@163.com","13568746687",3600,Date.valueOf("1995-03-18"),null,"精通java、oracle",dept,job);
			
			ed = new EmpDao();
			
			ed.insert(emp);
		}
	}
	
	@Test
	public void testGetCount() throws SQLException {
		EmpDao ed = new EmpDao();
		int count = ed.getCount();
		System.out.println(count);
	}
	
	@Test
	public void queryByPage() throws SQLException {
		EmpDao ed = new EmpDao();
		Page page = new Page(ed.getCount(),10,1);
		List<Emp> list = ed.queryByPage(page);
		for(Emp e : list) {
			System.out.println(e);
		}
		
	} 
	@Test
	public void updatePic() throws SQLException {
		EmpDao dao = new EmpDao();
		dao.updatePic("Rose", "dasdasds");
		
	}
}
