package com.cert.main;

import java.util.List;
import com.cert.job.CertJob;

public class Application {
	public static void main(String[] args)
		throws Exception {
			Long sTime = System.nanoTime();
			CertJob certJob = new CertJob();
			List<Throwable> errList = certJob.invokeProductResponseToFileJob("clientDomainName"); 

			if(errList.isEmpty()){
				doPrint("Job run without any errors");
			}else{
				doPrint(errList);
			}
			Long sTotal = System.nanoTime() - sTime;
			doPrint("Total time :\t" + sTotal*1e-9);
			
			
	}

	private static void  doPrint( Object obj ){    	
		System.out.println(obj.toString());
	}
}

