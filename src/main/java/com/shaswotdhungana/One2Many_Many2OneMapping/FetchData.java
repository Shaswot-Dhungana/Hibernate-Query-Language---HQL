package com.shaswotdhungana.One2Many_Many2OneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shaswotdhungana.One2OneMapping.Question;



public class FetchData {

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		
		// Building Session factory
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		
		
		// Session 
		
		Session  session = sessionFactory.openSession();
		
		
		// starting Transaction
		
		Transaction tx = session.beginTransaction();
		
		
//		Question question = (Question)session.get(Question.class, 2);
//		System.out.println(question.getQuestion());
//		System.out.println(question.getAnswer().getAnswer());		
		
	
		
		// Unidirectional (Fetching data from employee id)
		// Fetching from employeeDetail table.
		
		System.out.println("Fetching Via Unidirectional Mapping ");
		System.out.println("Fetching from employeeDetail table");
		
		EmpDtls empdtls = new EmpDtls();
		
		empdtls =session.get(EmpDtls.class, 201);
		System.out.println("Employee Name :~ "+empdtls.getName());
		
//		fetching multiple address of employee using for loop
		
		for(Address ad:empdtls.getAddress()) {
			
			System.out.println("Address Type :~ "+ad.getAddressType() + "Address :~ " + ad.getAddress());	
		}
		
		
		
		
		// Bi-directional (Fetching data from address id)
		
		System.out.println("Fetching Via By-directional Mapping ");
		System.out.println("Fetching from Employee Address table");
		
		Address address = new Address();
		address = session.get(Address.class, 101);
//		System.out.println("Employee Name :~ "+address.getEmpdtls().getName());
		System.out.println("Employee Name :~ "+empdtls.getName());
		System.out.println("Address Type :~ " + address.getAddressType());
		System.out.println("Address :~ " + address.getAddress());
		
		
		
		
		// saving to database
		
//		session.save(quest);
//		session.save(answer);
		
		// committing transaction.
		tx.commit();
//		
		
		// closing session
		session.close();
		
		
		// closing session factory
		sessionFactory.close();
		
		
		
		
	}
	
	
}
