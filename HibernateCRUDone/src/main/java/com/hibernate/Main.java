package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

//		UserDetails user = new UserDetails();
//		user.setUserName("User Update four");

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		/*
		 * CREATE for (int i = 0; i < 10; i++) { UserDetails user = new UserDetails();
		 * user.setUserName("User " + i); session.save(user); }
		 */
		/*
		 * READ UserDetails details = session.get(UserDetails.class, 2); //class,id
		 * System.out.println("Updating name : " + details.getUserName());
		 */
		/*
		 * UPDATE UserDetails details = session.get(UserDetails.class, 5);
		 * details.setUserName("Update"); session.update(details);
		 */
		/*
		 * DELETE UserDetails details = session.get(UserDetails.class, 4);
		 * session.delete(details);
		 */
		UserDetails user = session.get(UserDetails.class, 5);

		session.getTransaction().commit();
		session.close();

		user.setUserName("Updated after session close");

		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(user);

//		user.setUserName("Change after update session close");
		session.getTransaction().commit();
		session.close();

	}

}
