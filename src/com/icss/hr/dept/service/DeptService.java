package com.icss.hr.dept.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * ���T�I��
 * @author DLETC
 *
 */
public class DeptService {
	private DeptDao dao = new DeptDao();
	
	//���Ӳ��T
	public void addDept(Dept dept) throws SQLException {
		dao.insert(dept);
	}
	
	//�޸Ĕ���
	public void updateDept(Dept dept) throws SQLException {
		dao.update(dept);
	}
	
	//�h�����T
	public void deleteDept(int deptId) throws SQLException {
		dao.delete(deptId);
	}
	
	//��ԃ�΂����T
	public Dept queryDeptById(int deptId) throws SQLException {
		return dao.queryById(deptId);
	}
	
	//��ԃ���в��T
	public List<Dept> queryDept() throws SQLException {
		return dao.query();
	}
}
