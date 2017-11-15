package com.icss.hr.dept.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * 部門業務
 * @author DLETC
 *
 */
public class DeptService {
	private DeptDao dao = new DeptDao();
	
	//增加部門
	public void addDept(Dept dept) throws SQLException {
		dao.insert(dept);
	}
	
	//修改數據
	public void updateDept(Dept dept) throws SQLException {
		dao.update(dept);
	}
	
	//刪除部門
	public void deleteDept(int deptId) throws SQLException {
		dao.delete(deptId);
	}
	
	//查詢單個部門
	public Dept queryDeptById(int deptId) throws SQLException {
		return dao.queryById(deptId);
	}
	
	//查詢所有部門
	public List<Dept> queryDept() throws SQLException {
		return dao.query();
	}
}
