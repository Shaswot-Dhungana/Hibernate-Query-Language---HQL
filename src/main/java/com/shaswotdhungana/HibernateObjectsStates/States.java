package com.shaswotdhungana.HibernateObjectsStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shaswotdhungana.myhibernate.Certificate;
import com.shaswotdhungana.myhibernate.student;

public class States {

	// There are four types of Object States in Hibernate :~
	// 1. Transient State.
	// 2. Persistent State.
	// 3. Detached State.
	// 4. Removed State.

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {

		// Building session factory
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// Creating student object

		student student = new student();
		student.setUid(1234);
		student.setName("Shaswot Dhungana");
		student.setGender("Male");
		student.setCerti(new Certificate("Java Backend", "40 Hours"));
		// Till now the object student is in Transient State..

		// Session

		Session session = sessionFactory.openSession();

		// starting Transaction

		Transaction tx = session.beginTransaction();

		// saving to database

		session.save(student);
		// Now the object student is in Persistent State because
		// now this object is Associated with Session and Database..

		student.setName("Yama Raaj");
		// we can change/modify data of session object before committing
		// and new data will be reflected to database because session is
		// in SYNC With Database Now.
		// First Hibernate will insert Name: "Shaswot Dhungana" and
		// Then Update it with name: "Yama Raaj"
		
		

		// committing transaction.
		tx.commit();
		// After committing we cannot Modify/Change data of session object
		
		

		// closing session
		session.close();
		// Now After cLOSING/CLEARING Session our Object is Killed.
		// Now Our Object is in Detached State.
		// Detached state means object is nomore in session and data of object is saved in Database.
		
		// Removed State means if we remove object data in database but 
		// still that object is present in Session.
		
		

		// closing session factory
		sessionFactory.close();

	}

}
