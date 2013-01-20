package org.springbyexample.orm.jpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="JOB_DETAILS")
public class Job {
	
	private Long jobId;	
	private String jobName;
	private JobExecution jobexec;
	
	@OneToOne	
	@JoinColumn( name = "JOB_ID" )	
	public JobExecution getJobexec() {
		return jobexec;
	}

	public void setJobexec(JobExecution jobexec) {
		this.jobexec = jobexec;
	}

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
