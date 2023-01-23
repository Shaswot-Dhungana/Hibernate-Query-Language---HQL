package com.shaswotdhungana.HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;



public class HQLExampleJoinQuery {

	
	
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		
		Session session = sessionFactory.openSession();
		
		
	
		
		
		System.out.println("_____________________________________________________");
		
		// Join Data / Join Query
		
		
	// we need to begin transaction to perform write activity in database.. no need for read activity.
		
		Transaction tx = session.beginTransaction();
		


		
	
		Query q2 = session.createQuery("select q.question , q.questionId , a.answer from Questions as q INNER JOIN q.answer as a ");
		
		List<Object []> list2 = q2.getResultList();
		
		for(Object [] arr:list2) {
			
			System.out.println(Arrays.toString(arr));
			
		}
		
		
	
		tx.commit();
		
		session.close();
		sessionFactory.close();
		
	}
	
	
	
	
	
}
