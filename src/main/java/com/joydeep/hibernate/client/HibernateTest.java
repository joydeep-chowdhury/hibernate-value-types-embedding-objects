package com.joydeep.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.joydeep.hibernate.model.Address;
import com.joydeep.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails uds=new UserDetails();
		Address commonAddress=new Address();
		commonAddress.setCity("Kolkata");
		commonAddress.setPincode("700091");
		commonAddress.setState("West Bengal");
		commonAddress.setStreet("CL Block");
		uds.setUserName("Joydeep Chowdhury");
		uds.setAddress(commonAddress);
		uds.setJoinedDate(new Date());
		uds.setDescription("Description of the user goes here");
		
		UserDetails uds2=new UserDetails();
		uds2.setUserName("Pramit Karmakar");
		uds2.setAddress(commonAddress);
		uds2.setJoinedDate(new Date());
		uds2.setDescription("Description of the user goes here");
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(uds);
        session.save(uds2);
        session.getTransaction().commit();
        session.close();
	}

}
