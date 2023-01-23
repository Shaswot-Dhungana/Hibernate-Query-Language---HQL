package com.shaswotdhungana.One2Many_Many2OneMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;






public class App {

	public static void main(String[] args) {
		
		
		
		// Building Session factory
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		
		
		
		
		
		Address address1 = new Address(101 , "Permanent Address" , "Delhi , India" );
		Address address2 = new Address(102 , "Office Address" , "Kathmandu , Nepal" );
		
		List<Address> list = new ArrayList<Address>();
		list.add(address1);
		list.add(address2);
		
		
		EmpDtls employee = new EmpDtls();
		employee.setId(201);
		employee.setName("Shaswot-Dhungana");
		employee.setAddress(list);
		
		
		
		
		
		// Session opening 
		
		Session  session = sessionFactory.openSession();
		
		
		// starting Transaction
		
		Transaction tx = session.beginTransaction();
		
		
		// saving to database
	
		session.save(address1);
		session.save(address2);
		session.save(employee);
		
		
		// committing transaction.
		tx.commit();
		
		
		// closing session
		session.close();
		
		
		// closing session factory
		sessionFactory.close();
		
		
		
	}
	
	
}
