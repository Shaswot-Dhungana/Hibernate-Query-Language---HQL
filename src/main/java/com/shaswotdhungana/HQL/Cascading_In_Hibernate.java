package com.shaswotdhungana.HQL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shaswotdhungana.One2OneMapping.Answer;
import com.shaswotdhungana.One2OneMapping.Question;

public class Cascading_In_Hibernate {

	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		
		Question q1 = new Question();
		q1.setQuestion("What is Cascading ?");
		
		
		Answer a1 = new Answer(123 , "Cascading is very important topic in Hibernate.");
		Answer a2 = new Answer(124 , "Cascading is a chapter in Hibernate.");
		List<Answer> listA = new ArrayList<>();
		listA.add(a1);
		listA.add(a2);
		
		
	session.save(q1);
	session.save(a1);
	session.save(a2);
	
	
	tx.commit();
	
	session.close();
	sessionFactory.close();
	
	}
	
	
	
}
