package com.cert.dao;
import java.util.List;


import org.springframework.batch.item.ItemWriter;
//import com.cert.util.PersonServiceClient;
import com.cert.model.Person;
import com.cert.util.SampleClient;
import com.cert.util.ThreadExecuter;

public class ToServiceWriter implements ItemWriter<Person> {
	
	ThreadExecuter threadExecueter = ThreadExecuter.getSingleton();
  
	public void write(List<? extends Person> arg0) throws Exception {
	  
	  //System.out.println("In ToServiceWriter's write method.");
	  
	  for(Person person : arg0){
		//String sPerson = "Person Name :%s\tWork: %s";
		//System.out.println(String.format(sPerson, person.getName(),person.getWork()));
		//PersonServiceClient.callPersonservice(person);
		//SampleClient.callPersonService(person);  
		 
		  if(null == threadExecueter.postToService(person).get()){
			  System.out.println("Post to service successfull.");
		  }
	}
  }
}

	