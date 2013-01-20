package com.cert.dao;


import org.springframework.batch.item.ItemProcessor;

//import org.apache.axiom.om.impl.builder.StAXOMBuilder;

import com.cert.model.Person;
public class TransFormTOSoap implements ItemProcessor<Object,Object> {

	public Object process(Object arg0) throws Exception {
//		System.out.println("In TransFormTOSoap's process method.");		
		if(arg0 instanceof  Person){
//			Person person =(Person)arg0;
//			String sPerson = "Person Name :%s\tWork: %s";
//			System.out.println(String.format(sPerson, person.getName(),person.getWork()));
		}		
		return arg0;
	}

}
