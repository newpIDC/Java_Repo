package org.springbyexample.orm.jpa.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springbyexample.orm.jpa.dao.PersonDao;
import org.springbyexample.orm.jpa.domain.Address;
import org.springbyexample.orm.jpa.domain.Job;
import org.springbyexample.orm.jpa.domain.JobExecution;
import org.springbyexample.orm.jpa.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	
	
	public static ApplicationContext applicationContext = null;
	
	public static void main(String... args) {
		init();
		
		
		PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
		
		
		Person person = new Person();
		person.setFirstName("SomeFirstName");
		person.setLastName("SomeLastName");
		person.setCreated(new Date());
		
		
		Address address = new Address();
		address.setAddress("wells Fargo");
		address.setCity("HYB");
		address.setCountry("INDIA");
		address.setCreated(new Date());
		address.setZipPostal("500032");
		
		Address address_01 = new Address();
		address_01.setAddress("wells Fargo");
		address_01.setCity("HYB");
		address_01.setCountry("INDIA");
		address_01.setCreated(new Date());
		address_01.setZipPostal("500032");
		
		person.getAddress().add(address);
		person.getAddress().add(address_01);
		
		personDao.save(person);
		
		//personDao.saveAddress(55, address); 
		
		//person.setAddresses(setOfAddresses);
		//personDao.save(person);
		Job job = new Job();
		//job.setJobId(1L);
		job.setJobName("apsingh");
		
		JobExecution jobExecution = new JobExecution();
		//jobExecution.setJob(job);
		jobExecution.setJobExecutedate(new Date());
		job.setJobexec(jobExecution);
		
		Long id = personDao.saveJob(job);
		jobExecution.setJobId(47);
		personDao.saveJobExecution(47L ,jobExecution);
		
	
		
	}

	public static void init() {
	    String[] paths = {"PersonDaoTest-context.xml"};
	    applicationContext = new ClassPathXmlApplicationContext(paths);
	}
}
