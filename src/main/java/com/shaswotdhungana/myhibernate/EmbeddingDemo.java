package com.shaswotdhungana.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class EmbeddingDemo {

	public static void main(String[] args) {
		
		
		// building session factory
		
		  Configuration cfg = new Configuration();
	      cfg.configure("hibernate.cfg.xml");
	      SessionFactory sessionFactory = cfg.buildSessionFactory();
	      
	      
	      student student1 = new student();
//	      student1.setUid(0);
	      student1.setName("John Wick");
	      student1.setGender("BabaYaga");
	      
	      Certificate certificate = new Certificate();
	      
	      certificate.setCourse("BoogeyMan");
	      certificate.setDuration("LifeTime");
	      
	      student1.setCerti(certificate);
	      
	      
	      // opening session.
	      
	      Session session = sessionFactory.openSession();
	      
	      // opening transaction to save data to database
	      
	      Transaction tx = session.beginTransaction();
	      
	      tx.commit();
	      
	      
	      // saving objects
	      session.save(student1);
	      
	      // closing session.
	      session.close();
	      
	      // closing session factory..
	      sessionFactory.close();
		
	}
	
}
