package com.practice.ehcache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.ehcache.dao.Dao;

/**
 * Hello world!
 *
 */
public class App 
{
	public static ApplicationContext applicationContext;
    public static void main( String... args ) {    	
        System.out.println( "Hello World!" );
        init();
        Dao<Integer, String> dao = (Dao) applicationContext.getBean("personDao");
        dao.getPersonNamebyId(1);
    }
    
    public static void init() {
	    String[] paths = {"applicationContext.xml"};
	    applicationContext = new ClassPathXmlApplicationContext(paths);
	}
}
