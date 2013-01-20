package com.cert.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOB_DETAILS")
public class Job {
	
	private Long jobId;	
	private String jobName;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOB_ID")
	public Long getJobId() {
		return jobId;
	}
	
	@Column(name="JOB_NAME")
	public String getJobName() {
		return jobName;
	}
	
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}
