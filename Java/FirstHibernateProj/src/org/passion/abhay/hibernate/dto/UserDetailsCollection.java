package org.passion.abhay.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;



import javax.persistence.Column;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class UserDetailsCollection {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRRESS",
				joinColumns=@JoinColumn(name="USER_ID")
			  )	
	@GenericGenerator(name="hilo-gen", strategy ="hilo")
	@CollectionId(columns ={ @Column(name="ADDRESS_ID")}, generator="hilo-gen", type = @Type(type="long"))	
	private Collection<Address> listofAddresses = new ArrayList();
	//private Set<Address> listofAddresses = new HashSet();	
	
	public Collection<Address> getListofAddresses() {
		return listofAddresses;
	}

	public void setListofAddresses(Collection<Address> listofAddresses) {
		this.listofAddresses = listofAddresses;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}
	
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public String getUserName() {
		return userName ;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}  
}
