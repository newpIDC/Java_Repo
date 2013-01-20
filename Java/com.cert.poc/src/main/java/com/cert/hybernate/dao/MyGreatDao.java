package com.cert.hybernate.dao;

import java.sql.Connection;

import org.hibernate.HibernateException;
import org.hibernate.metamodel.relational.Value;

public interface MyGreatDao {  
	   public String getValueUsingJPAQL(long id);  
	   public Value getValueUsingJPA(long id) ;  
	   public String getValueUsingJDBC(long id);  
	   public Connection getConnection() throws HibernateException;  
}  