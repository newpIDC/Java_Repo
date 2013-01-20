package br.com.wbotelhos.spring.batch.model;

import java.util.Date;

public class Person {
	
	private int personid;
	private String fName;
	private String lName;
	private Date createdDate;
	
	public int getPersonid() {
		return personid;
	}
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public Date getCreatedDate() {
		return createdDate;
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
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
