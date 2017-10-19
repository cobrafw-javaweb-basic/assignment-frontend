/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: HibernateUtil.java
 *== Created at: Oct 18, 2017 10:06:56 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.util
 */
package vn.edu.ploy.duongnv21.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author duongnguyen
 *
 */
public class HibernateUtil {

	/** Session Factory */
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Build session factory
	 *
	 * @return SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {

		try {

			// Create the SessionFactory from hibernate.cfg.xml
			return  new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {

			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Get session factory
	 *
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Flush & close connection
	 */
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

	public static Session openSession() {
		return openSession();
	}
}
