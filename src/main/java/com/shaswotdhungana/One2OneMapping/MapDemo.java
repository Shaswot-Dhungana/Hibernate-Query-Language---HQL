package com.shaswotdhungana.One2OneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MapDemo {

	public static void main(String args[]) {
		
		// Building Session factory
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		
		
		Question quest = new Question();
//		quest.setQuestionId(2);
		quest.setQuestion("What is Java ?");
		
		// creating Answer
		
		Answer answer = new Answer();
		answer.setAnswerId(8);
		answer.setAnswer("Java is a Awesome Programming Language.");
		
		
		quest.setAnswer(answer);
		
		
		// Session 
		
		Session  session = sessionFactory.openSession();
		
		
		// starting Transaction
		
		Transaction tx = session.beginTransaction();
		
		
		// saving to database
		
		session.save(quest);
		session.save(answer);
		
		// committing transaction.
		tx.commit();
		
		
		// closing session
		session.close();
		
		
		// closing session factory
		sessionFactory.close();
		
		
		
		
	}
	
	
}
