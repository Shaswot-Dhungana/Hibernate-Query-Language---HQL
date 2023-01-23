package com.shaswotdhungana.HQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.shaswotdhungana.myhibernate.student;

public class HQLExampleDeleteData {

	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		
		Session session = sessionFactory.openSession();
		
		
		// HQL SYNTAX
		// HQL => from {EntityName if no entity name then class name.}
		// SQL => from {TableName}
		
//		String myQuery = "from student_details where uid=1";
//		String myQuery = "from student_details where gender=:x";
		
		// Fetch Data
		
		// using alias(as session)
		String myQuery = "from student_details as session where session.uid=:x and session.gender=:y";
		

		
		@SuppressWarnings("deprecation")
		Query q1 = session.createQuery(myQuery);
		
		q1.setParameter("x", 1);
		q1.setParameter("y", "male");
		
		
		List<student> list = q1.list();
		
		for(student student:list) {
			System.out.println(student.getName());
		}
		
		
		System.out.println("_____________________________________________________");
		
		// Delete Data
		@SuppressWarnings("deprecation")
		Query q2 = session.createQuery("delete from student_details as session where uid=:x and gender=:y");
		
		
		// we need to begin transaction to perform write activity in database.. no need for read activity.
		
		Transaction tx = session.beginTransaction();
		
		q2.setParameter("x", 3);
		q2.setParameter("y", "female");
		
		int r = q2.executeUpdate();
		System.out.println("Deleted : "+r);
		
		tx.commit();
		
		session.close();
		sessionFactory.close();
		
	}
	
	
	
	
	
}
