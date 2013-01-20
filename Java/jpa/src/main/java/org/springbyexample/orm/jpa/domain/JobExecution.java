package org.springbyexample.orm.jpa.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="JOB_EXEC" )
public class JobExecution {
	
	private Job job;	
	private Date jobExecutedate;
	private long jobId;
	
	@Id
	@Column( name = "JOB_ID")
	public long getJobId() {
		return jobId;
	}
	
	@OneToOne	
	@JoinColumn( name = "JOB_ID" )
	public Job getJob() {
		return job;
	}
	
	@Column( name = "job_start_date")
	public Date getJobExecutedate() {
		return jobExecutedate;
	}
	
	public void setJob(Job job) {
		this.job = job;
	}
	public void setJobExecutedate(Date jobExecutedate) {
		this.jobExecutedate = jobExecutedate;
	}
	
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
}
