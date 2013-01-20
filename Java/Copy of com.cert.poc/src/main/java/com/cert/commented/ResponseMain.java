package com.cert.commented;
/*package com.cert.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.wellsfargo.lbs.tmplegacyadaptercore.model.ResponseFile;
import com.wellsfargo.lbs.tmplegacyadaptercore.util.TmpLegacyAdapterUtil;


public class ResponseMain {
	
	
	public static void main(String args[]){
		ResponseJob responseJob = new ResponseJob();
		
		ResponseFile responseFile = new ResponseFile();
		responseFile.setStatus("IN_PROGRESS");
		responseFile.setFileName("L9.TST");
		responseFile.setProcessingStart(new java.sql.Timestamp(new Date().getTime()));
		responseFile.setClientDomain(new TmpLegacyAdapterUtil().getClientDomainByName("L9"));
		
		String id = responseJob.insertIntoResponseFile(responseFile);
		
		System.out.println("Inserted to RESPONSE_FILE .. id .. is "+id);
		try{
			 
			List errorList = responseJob.invokeProductResponseToFileJob("L9","L9.txt");
			
			//If no errors/Exceptions updating RESPONSE FILE STATUS to COMPLETE
			if(errorList.isEmpty()){
				
				responseFile.setResponseFileId(Integer.parseInt(id));
				responseFile.setStatus("COMPLETED");
				responseFile.setProcessingEnd(new java.sql.Timestamp(new Date().getTime()));
				System.out.println("DomainId --> "+ new TmpLegacyAdapterUtil().getClientDomainByName("L9").getClienDmnId());
				responseFile.setClientDomain(new TmpLegacyAdapterUtil().getClientDomainByName("L9"));
				responseFile.setFileName("L9.TST");
				
				responseJob.updateResponseFile(responseFile);
				
			} else {
				// Logging Error/Exception details to Logger
				Iterator iterator = errorList.iterator();
				int i=0;
				while(iterator.hasNext()){
					i++;
					System.out.println("Exception "+i+" "+iterator.next().toString()+"\n");
				}
				throw new Exception();
			}
		} catch(Exception e){
			e.printStackTrace();
			//Updating RESPONSE_FILE Status to FAILED.
			responseFile.setResponseFileId(Integer.parseInt(id));
			responseFile.setStatus("FAILED");
			responseFile.setExceptionText(e.getMessage());
			responseFile.setProcessingEnd(new java.sql.Timestamp(new Date().getTime()));
			responseFile.setClientDomain(new TmpLegacyAdapterUtil().getClientDomainByName("L9"));
			responseFile.setFileName("L9.TST");
			
			responseJob.updateResponseFile(responseFile);
		}
		
	}
}
*/