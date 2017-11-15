package com.icss.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 职务测试类
 * @author DLETC
 *
 */
public class TestJobDao {
	@Test
	public void insert() throws SQLException {
		Job j = new Job("开发",5000,8000);
		JobDao jd = new JobDao();
		jd.insert(j);
	}
	
	@Test
	public void update() throws SQLException {
		Job j = new Job(1,"测试",2000,5000);
		JobDao jd = new JobDao();
		jd.update(j);
	}
	
	@Test
	public void delete() throws SQLException {
		JobDao jd = new JobDao();
		jd.delete(81);
	}
	
	@Test
	public void selectById() throws SQLException {
		JobDao jd = new JobDao();
		jd.queryById(1);
	}
	
	@Test
	public void selectAll() throws SQLException {
		JobDao jd = new JobDao();
		List<Job> jl = new ArrayList<>();
		jl = jd.queryAll();
		for(Job j : jl) {
			System.out.println(j);
		}
	}
	
}
