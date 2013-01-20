package org.passion.abhay.hibernate.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
//@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle{
	private String steeringhandle;

	public String getSteeringhandle() {
		return steeringhandle;
	}

	public void setSteeringhandle(String steeringhandle) {
		this.steeringhandle = steeringhandle;
	}
	
	

}
