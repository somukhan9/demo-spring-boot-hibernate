package com.sam.util;

import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {

	/** The single instance of hibernate SessionFactory */
	// private static org.hibernate.SessionFactory sessionFactory;
	// private static
	private static HashMap<String, org.hibernate.SessionFactory> sessionFactory = new HashMap<String, org.hibernate.SessionFactory>();

	/**
	 * disable constructor to guaranty a single instance
	 */
	// String db;
	private SessionFactoryUtil(String db) {

		try {

			if (sessionFactory.get(db) == null) {
//				Configuration configuration = new Configuration();
//				//configuration.configure("hibernate.cfg.xml");
//				configuration.configure(db + ".hbm.cfg.xml");
//				//hibernate.cfg.xml
//				// for hbm 4.0 4.1 4.2
//				// ServiceRegistry serviceRegistry = new
//				// ServiceRegistryBuilder()
//				// .applySettings(configuration.getProperties()).buildServiceRegistry();
//				// for hbm 4.3
//				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//						.applySettings(configuration.getProperties()).build();
//				sessionFactory.put(db,
//						configuration.buildSessionFactory(serviceRegistry));
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure(db + ".hbm.cfg.xml").build();
				Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
				sessionFactory.put(db, metadata.getSessionFactoryBuilder().build());
			}
			//
		} catch (Exception e) {
			System.out.println("Cannot create sessionFactory, check settings.." + db + " " + e);
		}

	}

	/*
	 * static { try { // sessionFactory = new AnnotationConfiguration().configure
	 * ("hibernate2.cfg.xml").buildSessionFactory();
	 * 
	 * // newest code Configuration configuration = new Configuration();
	 * configuration.configure("hibernate2.cfg.xml"); // for hbm 4.0 4.1 4.2 //
	 * ServiceRegistry serviceRegistry = new ServiceRegistryBuilder() //
	 * .applySettings(configuration.getProperties()).buildServiceRegistry(); // for
	 * hbm 4.3 ServiceRegistry serviceRegistry = new
	 * StandardServiceRegistryBuilder()
	 * .applySettings(configuration.getProperties()).build(); sessionFactory.put(
	 * "",configuration.buildSessionFactory(serviceRegistry)); // } catch (Exception
	 * e) { System.out.println("Cannot create sessionFactory2, check settings.."); }
	 * }
	 */

	public static SessionFactory getInstance(String db) {
		if (sessionFactory.get(db) == null) {
			new SessionFactoryUtil(db);
		}
		return sessionFactory.get(db);
	}

	/**
	 * Opens a session and will not bind it to a session context
	 * 
	 * @return the session
	 */
	/*
	 * public Session openSession(String db) { return
	 * sessionFactory.get(db).openSession(); }
	 * 
	 *//**
		 * Returns a session from the session context. If there is no session in the
		 * context it opens a session, stores it in the context and returns it. This
		 * factory is intended to be used with a hibernate.cfg.xml including the
		 * following property
		 * <property name = "current_session_context_class">thread</property> This would
		 * return the current open session or if this does not exist, will create a new
		 * session
		 * 
		 * @return the session
		 */
	/*
	 * public Session getCurrentSession(String db) { //
	 * if(sessionFactory.isClosed()) // return sessionFactory.openSession(); Session
	 * session = sessionFactory.get(db).getCurrentSession(); if (session == null) {
	 * for (int i = 0; i < 10; i++) { // System.out.println("Session i:  "+i);
	 * session = sessionFactory.get(db).getCurrentSession(); if (session != null)
	 * break; } } return session; }
	 * 
	 *//**
		 * closes the session factory
		 *//*
			 * public static void close(String db) { if (sessionFactory != null)
			 * sessionFactory.get(db).close(); sessionFactory.put(db, null); }
			 */
}
