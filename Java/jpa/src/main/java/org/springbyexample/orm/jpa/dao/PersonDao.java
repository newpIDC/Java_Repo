package org.springbyexample.orm.jpa.dao;

import java.util.Collection;

import org.springbyexample.orm.jpa.domain.Address;
import org.springbyexample.orm.jpa.domain.Job;
import org.springbyexample.orm.jpa.domain.JobExecution;
import org.springbyexample.orm.jpa.domain.Person;

public interface PersonDao {
	
	public Person findPersonById(Integer id);

    /**
     * Find persons using a start index and max number of results.
     */
    
    public Collection<Person> findPersons(final int startIndex, final int maxResults);

    /**
     * Find persons.
     */
    
    public Collection<Person> findPersons() ;

    /**
     * Find persons by last name.
     */
    
    public Collection<Person> findPersonsByLastName(String lastName);

    /**
     * Saves person.
     */
    
    public void save(Person person);    
     
    public Long saveJob(Job job);    
    
    public void saveJobExecution(Long id, JobExecution jobexec);
    
    public Person update(Person person);   
    
    /**
     * Deletes person.
     */    
    public void delete(Person person);
    
    /**
     * Saves address to person.
     */    
   // public Person saveAddress(Integer id, Address address);
    /**
     * Deletes address from person.
     */
   // public Person deleteAddress(Integer id, Integer addressId);
    public Job findJobById(Long id) ;
    
    public Person saveAddress(Integer id, Address address);
    
    public Person deleteAddress(Integer id, Integer addressId);
}
