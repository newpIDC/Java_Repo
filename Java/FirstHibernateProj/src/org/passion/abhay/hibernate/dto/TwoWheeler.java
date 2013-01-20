package org.passion.abhay.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

//@Entity
//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle{
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
	
}
