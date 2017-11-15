package com.icss.hr.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DBUtil;
import com.icss.hr.common.Page;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;

/**
 * Ա��dao
 * @author DLETC
 *
 */
public class EmpDao {
	/**
	 * ��������
	 * @throws SQLException 
	 */
	public void insert(Emp emp) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into emp values (emp_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpLoginName());
		pstmt.setString(3, emp.getEmpPwd());
		pstmt.setString(4, emp.getEmpEmail());
		pstmt.setString(5, emp.getEmpPhone());
		pstmt.setDouble(6, emp.getEmpSalary());
		pstmt.setDate(7, emp.getEmpHiredate());
		pstmt.setInt(8, emp.getDept().getDeptId());
		pstmt.setInt(9, emp.getJob().getJobId());
		pstmt.setString(10, emp.getEmpPic());
		pstmt.setString(11, emp.getEmpInfo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
	}
	/**
	 * �޸�
	 * @param emp
	 * @throws SQLException 
	 */
	public void update(Emp emp) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update emp set emp_name=?,emp_phone=?,emp_salary=?,emp_dept_id=?,emp_job_id=?,emp_info=? where emp_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpPhone());
		pstmt.setDouble(3, emp.getEmpSalary());
		pstmt.setInt(4, emp.getDept().getDeptId());
		pstmt.setInt(5, emp.getJob().getJobId());
		pstmt.setString(6, emp.getEmpInfo());
		pstmt.setInt(7, emp.getEmpId());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
	}
	/**
	 * ���ݵ�¼���޸�����
	 * @param emp
	 * @throws SQLException
	 */
	public void updatePwd(Emp emp) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update emp set emp_pwd=? where emp_login_name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getEmpPwd());
		pstmt.setString(2, emp.getEmpLoginName());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	/**
	 * ���ݵ�¼���޸�����
	 * @throws SQLException 
	 */
	public void updatePic(String empLoginName,String empPic) throws SQLException {
		
		//�������
		Connection conn = DBUtil.getConnection();
		String sql = "update emp set emp_pic = ? where emp_login_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, empPic);
		pstmt.setString(2, empLoginName);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		
	}
	
	
	/**
	 * 
	 * @param empId
	 * @throws SQLException
	 */
	public void delete(int empId) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from emp where emp_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		pstmt.executeUpdate();
		
		pstmt.close();
		pstmt.close();
	}
	
	/**
	 * ����id��ѯEmp���ݣ������ѯ������Ҫ��ѯ�������ƺ�ְ�����ƣ�ֻ��Ҫ��id�洢��emp����
	 * @param empId
	 * @return
	 * @throws SQLException 
	 */
	public Emp queryById(int empId) throws SQLException {
		
		Connection conn = DBUtil.getConnection();
		String sql = "select * from emp where emp_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		Emp emp = null;
		Dept d = new Dept();
		Job j = new Job();
		while(rs.next()) {
			d.setDeptId(rs.getInt(9));
			j.setJobId(rs.getInt(10));
			emp = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getDate(8),rs.getString(11),rs.getString(12),d,j);
		}
		pstmt.close();
		conn.close();
		return emp;
	}
	
	
	/**
	 * �����¼�������ݵ�¼���Ʋ�ѯ����������Ա�����ݷ��أ�Ա����ţ�Ա���ĵ�¼������¼���룩
	 * ��¼�������ڣ�����null
	 * @param empName
	 * @return
	 * @throws SQLException 
	 */
	public Emp queryByLoginName(String empName) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select emp_id,emp_login_name,emp_pwd,emp_pic from emp where emp_login_name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, empName);
		ResultSet rs = pstmt.executeQuery();
		Emp emp = null;
		while(rs.next()) {
			emp = new Emp();
			emp.setEmpId(rs.getInt(1));
			emp.setEmpLoginName(rs.getString(2));
			emp.setEmpPwd(rs.getString(3));
			emp.setEmpPic(rs.getString(4));
		}
		pstmt.close();
		conn.close();
		return emp;
	}
	/**
	 * ���ر���ܼ�¼��
	 * @return
	 * @throws SQLException 
	 */
	public int getCount() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select count(*) from emp";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		int count = rs.getInt(1);
		
		rs.close();
		pstmt.close();
		conn.close();
		return count;
	}
	
	/**
	 * ��ҳ��ѯ����
	 * @param page
	 * @return
	 * @throws SQLException 
	 */
	public List<Emp> queryByPage(Page page) throws SQLException {
		Connection conn = DBUtil.getConnection();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM   (SELECT rownum r,");
		sb.append("               e.emp_id,");
		sb.append("               e.emp_name,");
		sb.append("               e.emp_login_name,");
		sb.append("               e.emp_pwd,");
		sb.append("               e.emp_email,");
		sb.append("               e.emp_phone,");
		sb.append("               e.emp_salary,");
		sb.append("               e.emp_hiredate,");
		sb.append("               d.dept_name,");
		sb.append("               j.job_name,");
		sb.append("               e.emp_info");
		sb.append("        FROM   emp e ");
		sb.append("        LEFT   JOIN dept d ON e.emp_dept_id = d.dept_id ");
		sb.append("        LEFT   JOIN job j ON e.emp_job_id = j.job_id) ");
		sb.append("WHERE  r BETWEEN ? AND ?");
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		pstmt.setInt(1, page.getStart());
		pstmt.setInt(2, page.getPageSize() * page.getPageNum());
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Emp> list = new ArrayList<>();
		
		while(rs.next()) {
			Dept dept = new Dept();
			dept.setDeptName(rs.getString(10));
			Job job = new Job();
			job.setJobName(rs.getString(11));
			Emp emp = new Emp(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getDate(9),null,rs.getString(12),dept,job);
			
			list.add(emp);
			
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	
 }
