/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: CategoryDao.java
 *== Created at: Oct 18, 2017 10:50:24 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.dao
 */
package vn.edu.ploy.duongnv21.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import vn.edu.ploy.duongnv21.model.Category;
import vn.edu.ploy.duongnv21.util.HibernateUtil;

/**
 * Assignment Demo -> CategoryDao
 *
 * @author duongnguyen
 */
public class CategoryDao {

	/** Hiberate DB Session */
	private Session session;

	/**
	 * Get list categories
	 *
	 * @return List Category
	 */
	public List<Category> getListCategories() {

		// Declare result variable
		List<Category> categoryList = null;

		// Handler error with try - catch - finally
		try {

			// Open Hibernate session
			this.openSession();

			// Create Hibernate Query
			Query<Category> query = this.session.createQuery(
									"from Category where fatherId is null order by sortNo" , Category.class);

			// Execute Hibernate query and get list result
			categoryList = query.list();

		} finally {
			// Close Hibernate session
			this.closeSession();
		}

		// Return result
		return categoryList;
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
