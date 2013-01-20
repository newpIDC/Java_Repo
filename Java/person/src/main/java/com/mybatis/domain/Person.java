package com.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

public final class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int personid ;
	private String fName = "";
	private String lName = "";
	private Date createddate;
	
	public int getPersonid() {
		return personid;
	}
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	
	
}
