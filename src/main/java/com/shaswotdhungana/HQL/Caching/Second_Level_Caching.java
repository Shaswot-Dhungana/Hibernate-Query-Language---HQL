package com.shaswotdhungana.HQL.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shaswotdhungana.myhibernate.student;

public class Second_Level_Caching {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// Second level caching is sessionFactory level caching and we need to do it manually.
		
		// Opening session 1
		Session session1 = sessionFactory.openSession();
		
		
		student st1 = session1.get(student.class, 11);
		System.out.println(st1);
		
		
		session1.close();
		
		
		
		// opening another session 2
		Session session2 = sessionFactory.openSession();
		
	
		student st2 = session1.get(student.class, 11);
		System.out.println(st2);
		
		
		
		session2.close();
		
		
		
		sessionFactory.close();
		
	}
	
}
