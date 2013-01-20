package com.practice.ehcache.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplate<K,V> {
	
	private Connection _connection = null;
	private void getConnection(){
		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");
 
		try { 
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) { 
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();			
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 	
 
		try { 
			_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/batch", "postgres","admin"); 
		} catch (SQLException e) { 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();		
 
		}
		
	}

	public V getbyId(K k){		 
		String name = "";	
		ResultSet resultSet = null;
		PreparedStatement  statement = null;
		getConnection();
	    try {	    	
	    	statement = _connection.prepareStatement("select first_name, last_name from person where person_id = ?");	    
	    	statement.setInt(1, (Integer) k);
	    	resultSet = statement.executeQuery();			
			while (resultSet.next()) {				 
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");
				
				System.out.println("first_name : " + first_name);
				System.out.println("last_name : " + last_name);
				name = first_name + " " + last_name;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			 if (resultSet != null) {
			        resultSet.close();
			 }
			 if (statement != null) {
			        statement.close();
			 }
			 if (_connection != null) {
			  		_connection.close();				
			 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
		return (V) name;
	}
}
