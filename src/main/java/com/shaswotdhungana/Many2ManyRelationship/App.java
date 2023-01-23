package com.shaswotdhungana.Many2ManyRelationship;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		
		// building session factory..
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		
		
		Emp emp1 = new Emp();
		Emp emp2 = new Emp();
		
		
		emp1.setEid(11);
		emp1.setName("Shaswot Dhungana");
		emp2.setEid(12);
		emp2.setName("Yama Raaj");
		
		
		Project pro1 = new Project();
		Project pro2 = new Project();
		
		pro1.setPid(1011);
		pro1.setProjectName("Front-End Development");
		pro2.setPid(1012);
		pro2.setProjectName("Back-End Development");
		
		
		List<Emp> empList = new ArrayList<Emp>();
		List<Project> proList = new ArrayList<Project>();
		
		empList.add(emp1);
		empList.add(emp2);
		
		proList.add(pro1);
		proList.add(pro2);
		
		
		emp1.setProjects(proList);
		pro1.setEmps(empList);
		
		
		
		// OPening SEssion
		
		Session session = sessionFactory.openSession();
		
		
		// Generating Transaction
		Transaction tx = session.beginTransaction();
		
		
		// saving Data to Database;;
		session.save(emp1);
		session.save(emp2);
		session.save(pro1);
		session.save(pro2);
		
		
		
		// committing transaction
		tx.commit();
		
		
		// Closing Session.
		session.close();
		
		
		
		// closing session factory
		sessionFactory.close();
		
		
	}
	
	
}
