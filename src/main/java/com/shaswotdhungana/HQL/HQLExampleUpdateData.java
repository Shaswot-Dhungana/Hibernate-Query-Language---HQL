package com.shaswotdhungana.HQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.shaswotdhungana.myhibernate.student;

public class HQLExampleUpdateData {

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
		
		// using alias(as session) in alias we use class field not table field.
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
		
		// Update Data / Update Query
		
		
	// we need to begin transaction to perform write activity in database.. no need for read activity.
		
		Transaction tx = session.beginTransaction();
		
		@SuppressWarnings("deprecation")
		Query q2 = session.createQuery("update  student_details set uid=:x , name=:y where uid=:m and name=:n");
		q2.setParameter("x", 10);
		q2.setParameter("y", "Shaswot2");
		q2.setParameter("m", 1);
		q2.setParameter("n", "Shaswot Dhungana");
		
		int r = q2.executeUpdate();
		System.out.println("Updated Rows : "+r);
		
	
		
	
		tx.commit();
		
		session.close();
		sessionFactory.close();
		
	}
	
	
	
	
}
