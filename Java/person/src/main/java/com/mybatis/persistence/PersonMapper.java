package com.mybatis.persistence;

import java.util.Date;
import java.util.List;

import com.mybatis.domain.Person;

public interface PersonMapper {
	
	void insertPerson(Person person);
	
	void deleteAll();
	
	List<Person> selectonDate(Date date);
}
