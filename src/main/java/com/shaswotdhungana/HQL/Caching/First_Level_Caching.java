package com.shaswotdhungana.HQL.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shaswotdhungana.myhibernate.student;



public class First_Level_Caching {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		// First Level Caching is  By Default enabled in Session Level.
		
		// Accessing data from database;
		System.out.println("Accessing data from database. [1st time]");
		student st1 = session.get(student.class, 11);
		System.out.println(st1.toString());
		
		
		
				// trying to Access data from database but hibernate itself do caching and showing result that are already in cache.;
				System.out.println("Trying to Accessing data from database. [2nd time]");
				student st2 = session.get(student.class, 11);
				System.out.println(st2.toString());
		
				
				// checking Object is present in Session Cache or not
				System.out.println("Object present in cache or not :~ "+session.contains(st1));
				System.out.println("Object present in cache or not :~ "+session.contains(st2));
				
				
					
		
		
		session.close();
		sessionFactory.close();
		
	}
	
	
}
