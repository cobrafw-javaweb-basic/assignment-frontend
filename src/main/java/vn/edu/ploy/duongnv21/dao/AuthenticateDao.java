/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: AuthenticateDao.java
 *== Created at: Oct 18, 2017 11:09:15 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.dao
 */
package vn.edu.ploy.duongnv21.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import vn.edu.ploy.duongnv21.model.Account;
import vn.edu.ploy.duongnv21.util.HibernateUtil;

/**
 * Assignment Demo -> AuthenticateDao
 *
 * @author duongnguyen
 */
public class AuthenticateDao {

	/** Hiberate DB Session */
	private Session session;

	/**
	 * Get login account
	 *
	 * @param username	Username
	 * @param password	Password
	 * @param userType	User type (admin, end-user)
	 *
	 * @return	Account
	 */
	public Account getLoginAccount(String username, String password, String userType) {

		// Declare reuslt variable
		Account account = null;

		// Handler error with try - catch - finally
		try {

			// Open Hibernate session
			this.openSession();

			// Create HQL query stirng
			String queryString = "from Account where username = :username and password = :password and type = :userType";

			// Create query & set param
			Query<Account> query = this.session.createQuery(queryString, Account.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			query.setParameter("userType", userType);

			// Get account
			account = query.uniqueResult();

		} finally {
			// Close Hibernate session
			this.closeSession();
		}

		// Return result
		return account;
	}

	/**
	 * Open Hibernate session
	 */
	private void openSession() {

		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	/**
	 * Close Hibernate session
	 */
	private void closeSession() {

		if (this.session != null && this.session.isOpen()) {
			this.session.close();
		}
	}
}
