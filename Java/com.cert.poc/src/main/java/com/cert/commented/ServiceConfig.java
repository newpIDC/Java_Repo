package com.cert.commented;
/*package com.cert.dao;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;



public class ServiceConfig implements Tasklet{
	
	*//** The Constant logger. *//*
	private static final Logger logger = Logger.getLogger(ServiceConfig.class);
 HashMap L9PropertiesMap;
 HashMap L9BulkPropertiesMap;
 HashMap L911PropertiesMap;
 HashMap IAMPropertiesMap;
	
private String file_name;
private String file_location;
private String resource;

 
 public void setFile_name(String fileName) {
	file_name = fileName;
}

public void setFile_location(String fileLocation) {
	file_location = fileLocation;
}

public void setResource(String resource) {
	this.resource = resource;
}

public HashMap loadProperties(){
	 
	 return null;
 }
 
 public HashMap getClientProperties(String domain){
	 
	 
	 return null;
 }

@Override
public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
		throws Exception {
	
	resource = (file_location.concat("\\")).concat(file_name);
	logger.info("the resource file path.."+resource);
	
	return RepeatStatus.FINISHED;
}
}
*/