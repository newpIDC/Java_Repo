package com.cert.job;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cert.main.Application;

public class CertJob {
	
	public static ApplicationContext applicationContext = Application.applicationContext;
	
	/*public void init() {
	    String[] paths = {"CertDBReadPostSoap.xml"};
	    applicationContext = new ClassPathXmlApplicationContext(paths);
	}
	*/
	public List<Throwable> invokeProductResponseToFileJob( String clientDomainName )
			throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException{
		
		//init();
		Job job = (Job )applicationContext.getBean("certDBReadPostSoapjob");
		
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		JobExecution jobExecution =  null;
				
		String query = "select NAME, WORK from PERSON";
			
		JobParametersBuilder jobParameters =  new JobParametersBuilder();	
		jobParameters.addString("query",query);
					
		//Launching "productResponseToFileJob" job	
		jobLauncher = (SimpleJobLauncher) applicationContext.getBean("jobLauncher");
		jobExecution = jobLauncher.run(job, jobParameters.toJobParameters());
		List<Throwable> exceptionsIfAny = jobExecution.getAllFailureExceptions();
		
		return exceptionsIfAny;
	}

}
