package org.passion.abhay.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name="UserDetails.byId",query="from UserDetails where userId > ?")
@NamedNativeQuery(name="UserDetails.byName",query="select * from User_Details where user_name = ?", resultClass=UserDetails.class)
@Table(name="USER_DETAILS")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class UserDetails {


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
}
