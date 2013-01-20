package com.practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataObject {
	
	private int data1 = 100;
	private String data2 = "hello";
	private Date date;
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private List<String> list = new ArrayList<String>() {
		{
		add("String 1");
		add("String 2");
		add("String 3");
	  }
	};
 
	//getter and setter methods
 
	@Override
	public String toString() {
	   return "DataObject [data1=" + data1 + ", data2=" + data2 + ", list="
		+ list + "]";
	}
}
