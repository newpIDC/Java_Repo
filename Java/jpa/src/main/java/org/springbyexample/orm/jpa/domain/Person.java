package org.springbyexample.orm.jpa.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person implements Serializable {

    private static final long serialVersionUID = -8712872385957386182L;

    private Integer id = null;
    private String firstName = null;
    private String lastName = null;
    private Set<Address> address = new HashSet<Address>();
    private Date created = null;

      
    
    /**
     * Gets id (primary key).
     */
    @Id
    @Column(name = "PERSON_ID")
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
     * Gets first name.
     */
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     */
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets list of <code>Address</code>es.
     */
    
   // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "PERSON_ADDRESS", joinColumns = { @JoinColumn(name = "PERSON_ID")},
    inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
    public Set<Address> getAddress() {
        return address;
    }

    /**
     * Sets list of <code>Address</code>es.
     */
   
    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    /**
     * Gets date created.
     */
    @Column( name = "CREATED_DATE")
    public Date getCreated() {
        return created;
    }

    /**
     * Sets date created.
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    

}