package com.mybatis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.mybatis.domain.Person;
import com.mybatis.persistence.PersonMapper;
import com.person.main.Main;

public class PersonService {
	
	@Autowired
	private PersonMapper _personMapper = (PersonMapper) Main.applicationContext.getBean(PersonMapper.class);

	
	
	public void insertPerson(Person person){
	
		_personMapper.insertPerson(person);
	}
	
	public void deleteAll(){		
		_personMapper.deleteAll();
	}
	
	public List<Person> selectonDate(Date date){
		 return	_personMapper.selectonDate(date);
	}

}
