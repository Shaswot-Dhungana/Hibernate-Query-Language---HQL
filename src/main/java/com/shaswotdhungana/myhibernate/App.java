package com.shaswotdhungana.myhibernate;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args ) throws  IOException , FileNotFoundException
    {
        System.out.println( "Project Running." );
        
        
        
        // Building Session Factory :~  
        
//      SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//      OR
//        
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        
      Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml");
      SessionFactory sessionFactory = cfg.buildSessionFactory();
        
      
      System.out.println(sessionFactory);
        System.out.println(sessionFactory.isClosed());
        
        
        
        // Taking data from input/keyboard/user.
        
        Scanner scanData = new Scanner(System.in);
        
        System.out.println("   Enter Student Name   :~  ");
		String st_name = scanData.nextLine();
        
		System.out.println("   ");
		System.out.println("   ");
		
		   System.out.println("   Enter Student Gender   :~  ");
			String st_gender = scanData.nextLine();
	        
		
			
			
			// creating object of  address and passing data.

			Address address = new Address();
			address.setStreet("Baluwa Taar");
			address.setCity("Kathmandu");
			address.setSafe(true);
			address.setAddedDate(new Date());
			address.setX(12.13);
			address.setImage(null);
			
//			//REading image
//			FileInputStream fis = new FileInputStream("src/main/java/wizard.png");
//			// storing image in byteType Array
//			byte[] data = new byte[fis.available()];
//			fis.read(data);
//			
//			address.setImage(data);
			
			
			
			
      
        // creating object of student and passing data.
        
        student st = new student();
        st.setName(st_name);
        st.setGender(st_gender);
        
        
        System.out.println(st);
        
        
        // saving in Database
        
        // opening  session.
        Session session = sessionFactory.openSession();
        
        // Starting transaction 
        Transaction tx = session.beginTransaction();
        
        session.save(st);
        session.save(address);
        
        // committing transaction
        tx.commit();
        
        // killing session
        session.close();
        
        
        System.out.println("Done .");
        
        
        
    }
}
