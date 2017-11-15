package com.icss.hr.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DBUtil;
import com.icss.hr.job.pojo.Job;

/**
 * Ö°Îñdao
 * @author DLETC
 *
 */
public class JobDao {
	
	
	public void insert(Job job) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into job values (job_seq.nextval,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, job.getJobName());
		pstmt.setInt(2, job.getJobMinSal());
		pstmt.setInt(3, job.getJobMaxSal());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public void update(Job job) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update job set job_name=?,job_min_sal=?,job_max_sal=? where job_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, job.getJobName());
		pstmt.setInt(2, job.getJobMinSal());
		pstmt.setInt(3, job.getJobMaxSal());
		pstmt.setInt(4, job.getJobId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public void delete(int jobId) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "delete from job where job_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public Job queryById(int jobId) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from job where job_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		ResultSet rs = pstmt.executeQuery();
		Job job = null;
		while(rs.next()) {
			job = new Job();
			job.setJobId(rs.getInt(1));
			job.setJobName(rs.getString(2));
			job.setJobMinSal(rs.getInt(3));
			job.setJobMaxSal(rs.getInt(4));
		}
		
		pstmt.close();
		conn.close();
		return job;
		
		
	}
	
	public List<Job> queryAll() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from job";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		Job job = null;
		List<Job> jobList = new ArrayList<>();
		while(rs.next()) {
			job = new Job();
			job.setJobId(rs.getInt(1));
			job.setJobName(rs.getString(2));
			job.setJobMinSal(rs.getInt(3));
			job.setJobMaxSal(rs.getInt(4));
			jobList.add(job);
		}
		
		pstmt.close();
		conn.close();
		return jobList;
	}
}
