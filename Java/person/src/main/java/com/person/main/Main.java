package com.person.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.domain.Hello;
import com.mybatis.domain.Person;
import com.mybatis.service.PersonService;

public class Main {

	/**
	 * @param args
	 * 
	 */
	public static ApplicationContext applicationContext = null;
	public static void main(String[] args) throws ParseException {
		init();
		
		Hello hello= (Hello) applicationContext.getBean("hello");
		System.out.println("Name:\t" + hello.getName());
		System.out.println("Work:\t" + hello.getWork());
		/*
		PersonService perService = new PersonService();
	
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		
    	Date date1 = sdf.parse("12-31-2009 04:30:45");
    	//Date date2 = sdf.parse("2010-01-31");

    	System.out.println(sdf.format(date1));
    	//System.out.println(sdf.format(date2));
		
		Date date = new Date();
		List<Person> lPerson = perService.selectonDate(date1);
		System.out.println(lPerson.size());
		*/
	/*	
		perService .deleteAll();
		
		for(int i=0; i< 100; i++){
			Person person = new Person();
			person.setName("Something_" + i);
			person.setWork("Something_" + i);
			perService.insertPerson(person);
			
		}*/
	}
	
	public static void  init() {
	    String[] paths = {"applicationContext.xml"};
	    applicationContext = new ClassPathXmlApplicationContext(paths);	    
	}

}
