package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.common.Page;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;

/**
 * Ա����ҵ��
 * @author DLETC
 *
 */
public class EmpService {
	private EmpDao ed = new EmpDao();
	
	/**
	 * �����û������룬��֤��¼
	 * @param empLoginName
	 * @param empPwd
	 * @return ����1�������ڣ�����2����������󣬷���3�����¼�ɹ�
	 * @throws SQLException 
	 */
	public int checkLogin(String empLoginName,String empPwd) throws SQLException {
		Emp emp = ed.queryByLoginName(empLoginName);
		
		if(emp == null) {
			return 1;
		}else if (!empPwd.equals(emp.getEmpPwd())) {
			return 2;
		}else {
			return 3;
		}
	}
	
	//����
	public void addEmp(Emp emp) throws SQLException {
		ed.insert(emp);
	} 
	
	//�޸�
	public void update(Emp emp) throws SQLException  {
		ed.update(emp);
	}
	//�޸�����
	public void updatePwd(Emp emp) throws SQLException  {
		ed.updatePwd(emp);
	}
	
	//ɾ��
	public void delete(int empId) throws SQLException {
		ed.delete(empId);
	}
	
	//��ѯid
	public Emp queryById(int empId) throws SQLException {
		return ed.queryById(empId);
	}
	
	//��ѯ����
	public List<Emp> queryEmpByPage(Page page) throws SQLException {
		return ed.queryByPage(page);
	}
	
	public Emp queryEmpByLoginName(String empLoginName) throws SQLException {
		return ed.queryByLoginName(empLoginName);
	}
	
	//����ܼ�¼��
	public int getEmpCount() throws SQLException {
		return ed.getCount();
	}
	
	/**
	 * �޸��û�ͷ��
	 * @throws SQLException 
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		ed.updatePic(empLoginName, empPic);
	}
}
