package com.cert.commented;
/*package com.cert.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.wellsfargo.dashboard.scheduler.exception.JobExecException;
import com.wellsfargo.dashboard.scheduler.job.IJob;
import com.wellsfargo.dashboard.scheduler.job.JobExecContext;
import com.wellsfargo.lbs.tmplegacyadaptercore.model.ResponseFile;
import com.wellsfargo.lbs.tmplegacyadaptercore.util.TmpLegacyAdapterUtil;

public class ResponseFileJob implements IJob{
	*//** The Constant logger. *//*
	private static final Logger logger = Logger.getLogger(ResponseFileJob.class);
	
	*//**
	 *(non-Javadoc)
	 * 
	 * @see com.wellsfargo.dashboard.scheduler.job.IJob#execute(com.wellsfargo.dashboard.scheduler.job.JobExecContext)
	 *//*
	public String execute(JobExecContext context, String arg1) throws JobExecException {
		
		//invoking model Object of Response Job
		ResponseJob responseJob = new ResponseJob();
		
		ResponseFile responseFile = new ResponseFile();
		responseFile.setStatus("IN_PROGRESS");
		responseFile.setFileName("L9.TST"); 
		responseFile.setProcessingStart(new java.sql.Timestamp(new Date().getTime()));
		responseFile.setClientDomain(new TmpLegacyAdapterUtil().getClientDomainByName("L9"));
		
		String responseFileID = responseJob.insertIntoResponseFile(responseFile);
		
		try{
			//invoking JOB
			List errorList = responseJob.invokeProductResponseToFileJob("L9","L9.txt"); // ("clientDmnName","FileNAme")
			
			//if Job ran Sucessfully updating RESPONSE_FILE status to "COMPLETED"
			if(errorList!=null && errorList.isEmpty()){
				responseFile.setResponseFileId(Integer.parseInt(responseFileID));
				responseFile.setStatus("COMPLETED");
				responseFile.setProcessingEnd(new java.sql.Timestamp(new Date().getTime()));
				responseFile.setClientDomain(new TmpLegacyAdapterUtil().getClientDomainByName("L9"));
				responseFile.setFileName("L9.TST");

				responseJob.updateResponseFile(responseFile);
				
			} else {
				//if any Errors/Failures occured writing them in logger 
				//and throwing exception changing STATUS to FAILED
				if(errorList!=null){
					Iterator iterator = errorList.iterator();
					int i=0;
					while(iterator.hasNext()){
						i++;
						logger.info("Exception "+i+" "+iterator.next().toString()+"\n");
					}
					throw new Exception();
				}
			}
			
		} catch(Exception e){
			e.printStackTrace();
			// Updating RESPONSE_FILE STATUS to "FAILED"
			responseFile.setResponseFileId(Integer.parseInt(responseFileID));
			responseFile.setStatus("FAILED");
			responseFile.setExceptionText(e.getMessage());
			responseFile.setProcessingEnd(new java.sql.Timestamp(new Date().getTime()));
			responseFile.setClientDomain(new TmpLegacyAdapterUtil().getClientDomainByName("L9"));
			responseFile.setFileName("L9.TST");
			responseJob.updateResponseFile(responseFile);
		}
		
		return "DONE";
	}
}
*/