package com.shaswotdhungana.HQL;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.shaswotdhungana.myhibernate.student;

public class HQLExampleFetchData {

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
		
		
		session.close();
		sessionFactory.close();
		
	}
	
	
}
