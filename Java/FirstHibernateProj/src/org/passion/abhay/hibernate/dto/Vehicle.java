package org.passion.abhay.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/*@Entity
@Table(name="VEHICLE")
@Inheritance(strategy=InheritanceType.JOINED)*/
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name= "VEHICLE_TYPE",
		discriminatorType = DiscriminatorType.STRING
)
*/
public class Vehicle {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	@Column(name="VEHICLE_NAME")
	private String vehicleName;
	//For manyToone use this

	/*@ManyToOne
	@JoinColumn(name="USER_ID")	
	@NotFound(action=NotFoundAction.IGNORE)
	private UserDetailsMapping user;
	*/
	//@ManyToMany(mappedBy="vehicle")
	//private Collection<UserDetailsMapping> userList = new ArrayList<UserDetailsMapping>();
	/*
	public Collection<UserDetailsMapping> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetailsMapping> userList) {
		this.userList = userList;
	}*/
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
