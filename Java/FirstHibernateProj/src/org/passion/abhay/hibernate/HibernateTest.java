package org.passion.abhay.hibernate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.passion.abhay.hibernate.dto.Address;
import org.passion.abhay.hibernate.dto.FourWheeler;
import org.passion.abhay.hibernate.dto.TwoWheeler;
import org.passion.abhay.hibernate.dto.UserDetailsCollection;
import org.passion.abhay.hibernate.dto.UserDetailsMapping;
import org.passion.abhay.hibernate.dto.UserDetails;
import org.passion.abhay.hibernate.dto.Vehicle;

public class HibernateTest {

	/**
	 * @param arg
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] arg){
				
		/*UserDetailsCollection user = new UserDetailsCollection ();
		
		user.setUserName("First User");		
		user.setJoiningDate(new Date());
		*/
		/*Address addr = new Address();
		addr.setCity("HYD");
		addr.setPincode("9999");
		addr.setState("AP");
		addr.setStreet("TolliChauki");
		
		Address addr2 = new Address();
		addr2.setCity("HYD_");
		addr2.setPincode("9999_");
		addr2.setState("AP_");
		addr2.setStreet("TolliChauki_");

		user.getListofAddresses().add(addr);
		user.getListofAddresses().add(addr2);*/
		
		/*UserDetailsMapping user = new UserDetailsMapping();
		user.setUserName("First User");
		
		Vehicle vehicle = new Vehicle(); 
		vehicle.setVehicleName("Maruti");
		
		Vehicle vehicle2 = new Vehicle(); 
		vehicle2.setVehicleName("Honda");
		
		
		TwoWheeler th = new TwoWheeler();
		th.setSteeringHandle("Scooter");
		th.setVehicleName("scooter");
		
		
		FourWheeler fh = new FourWheeler();
		fh.setSteeringhandle("Porch");
		fh.setVehicleName("Porch");
	
		user.setUserName("First User");
	*/	/*
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		user.getVehicle().add(th);
		user.getVehicle().add(fh);
		*///vehicle.getUserList().add(user);
		//vehicle2.getUserList().add(user);
		//SessionFactory  sessionFactory = new Configuration().configure().buildSessionFactory();
		/*UserDetails usr = new UserDetails();
		usr.setUserName("User");
		*///transient
		
		SessionFactory  sessionFactory =  configureSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//session.save(usr);
		//UserDetails user = (UserDetails)session.get(UserDetails.class,1);
		
		//user.setUserName("Updated again user name");
		//session.update(user);
		//user.setUserName("Updated after update User Name");
		//session.persist(user);
		
		/*session.save(vehicle);
		session.save(vehicle2);
		session.save(th);
		session.save(fh);*/
		
		/*for(int i=0;i<10;i++){
			UserDetails usr = new UserDetails(); 
			usr.setUserName("User"+ i);
			session.save(usr);
		}*/
		//UserDetails usr = (UserDetails)session.get(UserDetails.class, 5);
		//System.out.println("User pulled up =" + usr.getUserName());
		//session.delete(usr);
		
		//usr.setUserName("Updated UserName");		
		//session.update(usr);
		String minUserId = "5";
		//Query  query = session.createQuery("from UserDetails where userId > ?");
		//query.setInteger(0, Integer.parseInt(minUserId));
		
		/*Query  query = session.createQuery("from UserDetails where userId > :userId");
		query.setInteger("userId", Integer.parseInt(minUserId));
		*/
		/*Query  query = session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, Integer.parseInt(minUserId));
		*/
		
		//Query  query = session.getNamedQuery("UserDetails.byName");
		//query.setString(0, "User1");
		
		//Query  query = session.createQuery("select userId, userName from UserDetails");
		//query.setFirstResult(4);
		//query.setMaxResults(4);
		//List<UserDetails> list = (List<UserDetails>)query.list(); 
		//List<Object[]> list = (List<Object[]>)query.list();
		
		//Criteria criteria = session.createCriteria(UserDetails.class);
		//criteria.add(Restrictions.like("userName", "%User%"))
		//	.add(Restrictions.gt("userId", 5));
		
		//Criteria criteria = session.createCriteria(UserDetails.class)
			//	.addOrder(Order.asc("userId"));
				//.setProjection(Projections.max("userId"));	
				//.setProjection(Projections.property("userId"));
		
		
		//criteria.add(Restrictions.or(Restrictions.like("userName", "%User%"),Restrictions.gt("userId", 5)));
		UserDetails user = new UserDetails();
		//user.setUserId(5);
		user.setUserName("User1%");
		
		//Example exaple = Example.create(user).excludeProperty("userName");
		Example example = Example.create(user).enableLike();
		Criteria criteria = session.createCriteria(UserDetails.class)
						.add(example);
		List<UserDetails> list = (List<UserDetails>)criteria.list();
		
		session.getTransaction().commit();
		//persistent
		session.close();
		
		/*for(UserDetails udt : list){
			System.out.println(udt.getUserName());
		}*/

		for(UserDetails udt : list){
			System.out.println(udt.getUserName());
		}
		/*Class cls = list.get(0)[0].getClass();  
	    System.out.println("The type of the object is: " + cls.getName());
		
		for(Object[] udt : list){			
			for(Object s : udt){
				System.out.println(s);
			}
		}*/
		
		//System.out.println("User pulled up =" + usr.getUserName());
		/*user = null;
	    session = sessionFactory.openSession();
	    user = (UserDetailsCollection)session.get(UserDetailsCollection.class, 1);
	    System.out.println(user.getUserName());
	    session.close();
	    System.out.println(user.getListofAddresses().size());*/
	   
		//Detached
		
		/*Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session.update(user);
		session2.getTransaction().commit();
		session2.close();*/
	}
	
	private static SessionFactory _sessionFactory;
	private static ServiceRegistry _serviceRegistry;
	
	private static SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    _serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    _sessionFactory = configuration.buildSessionFactory(_serviceRegistry);
	    return _sessionFactory;
	}
}
