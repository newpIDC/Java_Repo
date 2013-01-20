package org.springbyexample.orm.jpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 7851794269407495684L;

    private Integer id = null;
    private String address = null;
    private String city = null;
    private String state = null;
    private String zipPostal = null;
    private String country = null;
    private Date created = null;
  
    
   
	//private Person person;
    
    /**
     * Gets id (primary key).
     */
    @Id
    @Column( name = "ADDRESS_ID", insertable = false ,updatable = false) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    /**
     * Sets id (primary key).
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets address.
     */
    @Column( name = "ADDRESS" )
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets city.
     */
    @Column( name = "CITY" )
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     */
    @Column( name = "STATE")
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets zip or postal code.
     */
    @Column(name = "ZIP_POSTAL")
    public String getZipPostal() {
        return zipPostal;
    }

    /**
     * Sets zip or postal code.
     */
    public void setZipPostal(String zipPostal) {
        this.zipPostal = zipPostal;
    }

    /**
     * Gets country.
     */
    @Column( name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets date created.
     */
    @Column( name = "CREATED_DATE" )
    public Date getCreated() {
        return created;
    }

    /**
     * Sets date created.
     */
    public void setCreated(Date created) {
        this.created = created;
    }
    
   /* @ManyToOne
   	@JoinColumn(name="ADDRESS_ID",insertable=false, updatable=false)    
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}  
*/
}