package com.icss.hr.job.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * ְ��ҵ��
 * @author DLETC
 *
 */
public class JobService {
	JobDao jd = new JobDao();
	
	//���ӹ���ҵ��
	public void addJob(Job job) throws SQLException {
		jd.insert(job);
	}
	
	//�޸Ĺ���ҵ��
	public void updateJob(Job job) throws SQLException {
		jd.update(job);
	}
	
	//ɾ��ҵ��
	public void deleteJob(int jobId) throws SQLException {
		jd.delete(jobId);
	}
	
	//��id��ѯ
	public Job queryById(int jobId) throws SQLException {
		return jd.queryById(jobId);
	}
	
	//��ѯ����job
	public List<Job> queryAll() throws SQLException {
		return jd.queryAll();
	}
}
