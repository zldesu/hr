package com.icss.hr.job.pojo;
/**
 * ְ��ʵ����
 * @author DLETC
 *
 */
public class Job {
	private int jobId;
	private String jobName;
	private int jobMinSal;
	private int jobMaxSal;
	
	public Job() {
		super();
	}

	public Job(String jobName, int jobMinSal, int jobMaxSal) {
		super();
		this.jobName = jobName;
		this.jobMinSal = jobMinSal;
		this.jobMaxSal = jobMaxSal;
	}

	public Job(int jobId, String jobName, int jobMinSal, int jobMaxSal) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobMinSal = jobMinSal;
		this.jobMaxSal = jobMaxSal;
	}

	public int getJobId() {
		return jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public int getJobMinSal() {
		return jobMinSal;
	}

	public int getJobMaxSal() {
		return jobMaxSal;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setJobMinSal(int jobMinSal) {
		this.jobMinSal = jobMinSal;
	}

	public void setJobMaxSal(int jobMaxSal) {
		this.jobMaxSal = jobMaxSal;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", jobMinSal=" + jobMinSal + ", jobMaxSal=" + jobMaxSal
				+ "]";
	}
	
	
}
