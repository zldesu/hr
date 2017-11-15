package com.icss.hr.job.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 职务业务
 * @author DLETC
 *
 */
public class JobService {
	JobDao jd = new JobDao();
	
	//增加工作业务
	public void addJob(Job job) throws SQLException {
		jd.insert(job);
	}
	
	//修改工作业务
	public void updateJob(Job job) throws SQLException {
		jd.update(job);
	}
	
	//删除业务
	public void deleteJob(int jobId) throws SQLException {
		jd.delete(jobId);
	}
	
	//按id查询
	public Job queryById(int jobId) throws SQLException {
		return jd.queryById(jobId);
	}
	
	//查询所有job
	public List<Job> queryAll() throws SQLException {
		return jd.queryAll();
	}
}
