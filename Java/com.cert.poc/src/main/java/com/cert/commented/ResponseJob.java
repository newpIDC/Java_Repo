package com.cert.commented;
/*package com.cert.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.lbs.tmplegacyadaptercore.dao.ResponseFileJobDAO;
import com.wellsfargo.lbs.tmplegacyadaptercore.model.ResponseFile;

*//**
 * @author A171936
 *
 *//*
public class ResponseJob {
	
	private static final Logger logger = Logger.getLogger(ResponseJob.class);
		
	public static ApplicationContext applicationContext = null;
	
	ResponseFileJobDAO reqfilejobdao = new ResponseFileJobDAO();
	
	public void init() {
	    String[] paths = {"ProductResponseDataToFile.xml"};
	    applicationContext = new ClassPathXmlApplicationContext(paths);
	}
	
	public String insertIntoResponseFile(ResponseFile responseFile){
		String id = reqfilejobdao.persistResponseFileData(responseFile);
		return id;
	}
	
	public List invokeProductResponseToFileJob(String clientDomainName,String fileName) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException{
		init();
		Job job = (Job )applicationContext.getBean("productResponseToFileJob");
		
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		JobExecution jobExecution =  null;
		
		String query = "select  response.product_response_id,response.response from " +
				"LGRIDSRVO.product_response response," +
				"LGRIDSRVO.client_dmn cDomian," +
				"LGRIDSRVO.product_request request," +
				"LGRIDSRVO.request_file reqFile " +
				"where " +
				"request.client_reference_id = response.client_reference_id " +
				"and reqFile.request_file_id = request.request_file_id " +
				"and reqFile.client_dmn_id = cDomian.client_dmn_id " +
				"and response.status = 'NOT SENT'" +
				"and cDomian.client_nm = '"+clientDomainName+"'";
		
		logger.debug("Query.. "+query);
		
		String file = fileName;
			
		//Setting Job Parameters "query" and "file". and accessing them in 
		
		JobParametersBuilder jobParameters =  new JobParametersBuilder();	
			jobParameters.addString("query",query);
			jobParameters.addString("file", file);
			
		//Launching "productResponseToFileJob" job	
		jobLauncher = (SimpleJobLauncher) applicationContext.getBean("jobLauncher");
		jobExecution = jobLauncher.run(job, jobParameters.toJobParameters());
		List exceptionsIfAny = jobExecution.getAllFailureExceptions();
		
		return exceptionsIfAny;
	}
	
	public void updateProductResponseStatus(String productResponseID) throws SQLException{
			reqfilejobdao.updateProductResponse(productResponseID);       	
	}
	
	public void updateResponseFile(ResponseFile responseFile){
		reqfilejobdao.updateResponseFileData(responseFile);
	}
	
}
*/