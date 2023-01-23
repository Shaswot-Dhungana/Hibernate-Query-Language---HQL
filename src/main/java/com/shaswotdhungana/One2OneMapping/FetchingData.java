package com.shaswotdhungana.One2OneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class FetchingData {

	public static void main(String args[]) {
		
		// Building Session factory
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		
		
		// Session 
		
		Session  session = sessionFactory.openSession();
		
		
		// starting Transaction
		
		Transaction tx = session.beginTransaction();
		
		
		// Fetching using 
		Question question = (Question)session.get(Question.class, 1);
		System.out.println("Question ID :~ " + question.getQuestionId());
		System.out.println("Question :~ " + question.getQuestion());
		System.out.println("Answer :~ " + question.getAnswer().getAnswer());
		
		
		
		
		
		// saving to database
		
//		session.save(quest);
//		session.save(answer);
		
		// committing transaction.
//		tx.commit();
//		
		
		// closing session
		session.close();
		
		
		// closing session factory
		sessionFactory.close();
		
		
		
		
	}
	
	
}
