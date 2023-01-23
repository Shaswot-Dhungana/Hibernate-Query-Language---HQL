package com.shaswotdhungana.HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.shaswotdhungana.myhibernate.student;

public class Native_SQL_in_Hibernate {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory =  cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		// This is sql query...
		String sqlQuery = "select * from student_details";
		
		@SuppressWarnings({ "deprecation", "rawtypes" })
		NativeQuery nq = session.createNativeQuery(sqlQuery);
		
		@SuppressWarnings("unchecked")
		List<Object []> list1 = nq.list();
		
		for(Object [] s:list1) {
			
			System.out.println(s[4] + " is " + s[3]);

			
		}
		
		
		session.close();
		sessionFactory.close();
		
		
		
	}
	
	
}
