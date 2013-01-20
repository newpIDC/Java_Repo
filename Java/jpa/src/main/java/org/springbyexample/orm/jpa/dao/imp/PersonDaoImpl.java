package org.springbyexample.orm.jpa.dao.imp;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springbyexample.orm.jpa.dao.PersonDao;
import org.springbyexample.orm.jpa.domain.Address;
import org.springbyexample.orm.jpa.domain.Job;
import org.springbyexample.orm.jpa.domain.JobExecution;
import org.springbyexample.orm.jpa.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository( value = "personDao")
@Transactional(readOnly = true)
public class PersonDaoImpl implements PersonDao {

    private EntityManager em = null;

    /**
     * Sets the entity manager.
     * 
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Find persons.
     */
    public Person findPersonById(Integer id) {
        return em.find(Person.class, id);
    }

    /**
     * Find persons using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")
    public Collection<Person> findPersons(final int startIndex, final int maxResults) {
        return em.createQuery("select p from Person p order by p.lastName, p.firstName")
            .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
    }

    /**
     * Find persons.
     */
    @SuppressWarnings("unchecked")
    public Collection<Person> findPersons() {
        return em.createQuery("select p from Person p order by p.lastName, p.firstName").getResultList();
    }

    /**
     * Find persons by last name.
     */
    @SuppressWarnings("unchecked")
    public Collection<Person> findPersonsByLastName(String lastName) {
        return em.createQuery("select p from Person p where p.lastName = :lastName order by p.lastName, p.firstName")
            .setParameter("lastName", lastName).getResultList();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void save(Person person) {    
         em.persist(person);
    }
    
    /**
     * Saves person.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Person update(Person person) {    
         return em.merge(person);
    }

    /**
     * Deletes person.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Person person) {
        em.remove(em.merge(person));
    }

    /**
     * Saves address to person.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Person saveAddress(Integer id, Address address) {
        Person person = findPersonById(id);

        /*if (person.getAddres().contains(address)) {
            person.getAddresses().remove(address);
        }
        
        person.getAddresses().add(address);   */     

        return update(person);
    }

    /**
     * Deletes address from person.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Person deleteAddress(Integer id, Integer addressId) {
        Person person = findPersonById(id);

        Address address = new Address();
        address.setId(addressId);

        /*if (person.getAddresses().contains(address)) {
            for (Address a : person.getAddresses()) {
                if (a.getId().equals(addressId)) {
                    em.remove(a);
                    person.getAddresses().remove(address);
                    
                    break;
                }
            }
        }*/

        return person;
    }

        
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Long saveJob( Job job ){    	
    	 return em.merge(job).getJobId();    	
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void saveJobExecution(Long id, JobExecution jobExec ){
    	
    	Job job  = findJobById(id);    	
    	if(job != null){
    		em.merge(jobExec);
    	}
    }


    
    public Job findJobById(Long id) {
        return em.find(Job.class, id);
    }	
}