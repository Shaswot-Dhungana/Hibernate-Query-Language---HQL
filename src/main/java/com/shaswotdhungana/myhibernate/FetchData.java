package com.shaswotdhungana.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// opening session.
		Session session = sessionFactory.openSession();

		// get - student - data ; using get method.
		// previous entity class => student.class and pass uid/id number of user.

		System.out.println("Using Get method.........");
		student studentGet = (student) session.get(student.class, 1);

		System.out.println(studentGet);

		Address addressGet = (Address) session.get(Address.class, 1);

		System.out.println(addressGet.getCity());

		// using load method...
		System.out.println("Using Load method.........");
		student studentLoad = (student) session.load(student.class, 1);
		System.out.println(studentLoad);

		Address addressLoad = (Address) session.load(Address.class, 1);

		System.out.println(addressLoad.getCity());

		// closing session factory
		sessionFactory.close();

	}

}
