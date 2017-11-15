package com.icss.hr.emp.pojo;

import java.sql.Date;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.job.pojo.Job;

/**
 * 员工的实体类
 * @author DLETC
 *
 */
public class Emp {
	private int empId;
	private String empName;
	private String empLoginName;
	private String empPwd;
	private String empEmail;
	private String empPhone;
	private double empSalary;
	private Date   empHiredate;
	private String empPic;
	private String empInfo;
	
	private Dept dept;//多对一关系
	private Job	 job;
	
	public Emp() {
		super();
	}

	public Emp(int empId, String empName, String empLoginName, String empPwd, String empEmail, String empPhone,
			double empSalary, Date empHiredate, String empPic, String empInfo, Dept dept, Job job) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empLoginName = empLoginName;
		this.empPwd = empPwd;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empSalary = empSalary;
		this.empHiredate = empHiredate;
		this.empPic = empPic;
		this.empInfo = empInfo;
		this.dept = dept;
		this.job = job;
	}

	public Emp(String empName, String empLoginName, String empPwd, String empEmail, String empPhone, double empSalary,
			Date empHiredate, String empPic, String empInfo, Dept dept, Job job) {
		super();
		this.empName = empName;
		this.empLoginName = empLoginName;
		this.empPwd = empPwd;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empSalary = empSalary;
		this.empHiredate = empHiredate;
		this.empPic = empPic;
		this.empInfo = empInfo;
		this.dept = dept;
		this.job = job;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpLoginName() {
		return empLoginName;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public Date getEmpHiredate() {
		return empHiredate;
	}

	public String getEmpPic() {
		return empPic;
	}

	public String getEmpInfo() {
		return empInfo;
	}

	public Dept getDept() {
		return dept;
	}

	public Job getJob() {
		return job;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public void setEmpHiredate(Date empHiredate) {
		this.empHiredate = empHiredate;
	}

	public void setEmpPic(String empPic) {
		this.empPic = empPic;
	}

	public void setEmpInfo(String empInfo) {
		this.empInfo = empInfo;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empLoginName=" + empLoginName + ", empPwd=" + empPwd
				+ ", empEmail=" + empEmail + ", empPhone=" + empPhone + ", empSalary=" + empSalary + ", empHiredate="
				+ empHiredate + ", empPic=" + empPic + ", empInfo=" + empInfo + ", dept=" + dept + ", job=" + job + "]";
	} 
	
	
	
	
	
}
