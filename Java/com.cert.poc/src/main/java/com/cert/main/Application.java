package com.cert.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cert.job.CertJob;

public class Application {
	
	public static ApplicationContext applicationContext = null;
	public static void main(String[] args)
		throws Exception {
			init();
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
	
	public static void init() {
	    String[] paths = {"CertDBReadPostSoap.xml"};
	    applicationContext = new ClassPathXmlApplicationContext(paths);
	}
	

	private static void  doPrint( Object obj ){    	
		System.out.println(obj.toString());
	}
}

