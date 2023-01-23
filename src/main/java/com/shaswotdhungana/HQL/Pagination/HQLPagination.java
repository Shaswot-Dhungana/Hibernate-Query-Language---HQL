package com.shaswotdhungana.HQL.Pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.shaswotdhungana.myhibernate.student;



public class HQLPagination {

	public static void main(String[] args) {

		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		Query<student> q = session.createQuery("from student_details");
		
		
		// Implementing Pagination using hibernate.
		// start from 0 (Zeroth) row in database..
		q.setFirstResult(0);
		// End till 5 (Fifth) row in database.
		q.setMaxResults(5);
		
		List<student> list1 = q.list();
		
		for(student st:list1) {
			
			System.out.println("UID :~ "+st.getUid()+" Name :~ "+st.getName()+" Gender :~ "+st.getGender());
			
		}
		
		
		
		session.close();
		sessionFactory.close();
		
		
	}
	
	
	
	
}
