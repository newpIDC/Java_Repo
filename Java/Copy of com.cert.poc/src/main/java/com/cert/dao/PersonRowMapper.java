package com.cert.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cert.model.Person;

public class PersonRowMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		if (rs == null) {
			return null;
		}	
		Person person = new Person();
		person .setName(rs.getString("NAME"));
		person.setWork(rs.getString("WORK"));
		//String sPerson = "Person Name :%s\tWork: %s";
		//System.out.println(String.format(sPerson, person.getName(),person.getWork()));
		
		
		return person;
	}
}
