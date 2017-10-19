/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: ProductDao.java
 *== Created at: Oct 18, 2017 11:08:56 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.dao
 */
package vn.edu.ploy.duongnv21.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import vn.edu.ploy.duongnv21.model.Product;
import vn.edu.ploy.duongnv21.util.HibernateUtil;

/**
 * Assignment Demo -> ProductDao
 *
 * @author duongnguyen
 */
public class ProductDao {

	/** Hiberate DB Session */
	private Session session;

	/**
	 * Get list product
	 *
	 * @return List Product
	 */
	public List<Product> getListProduct() {

		// Declare result variable
		List<Product> listProduct = null;

		// Handler error with try - catch - finally
		try {

			// Open Hibernate session
			this.openSession();

			// Query data
			Query<Product> query = this.session.createQuery("from Product", Product.class);
			listProduct = query.getResultList();

		} finally {
			// Close Hibernate session
			this.closeSession();
		}

		// Return result
		return listProduct;
	}

	/**
	 * Get list product
	 *
	 * @return List Product
	 */
	public List<Product> getListProduct(Integer categoryId) {

		// Declare result variable
		List<Product> listProduct = null;

		// Handler error with try - catch - finally
		try {

			// Open Hibernate session
			this.openSession();

			// Query data
			Query<Product> query = this.session.createQuery("from Product where categoryId = :categoryId", Product.class);
			query.setParameter("categoryId", categoryId);
			listProduct = query.getResultList();

		} finally {
			// Close Hibernate session
			this.closeSession();
		}

		// Return result
		return listProduct;
	}

	/**
	 * Get product by ID
	 *
	 * @param id Product ID
	 *
	 * @return Product
	 */
	public Product getProduct(Integer id) {

		// Declare result variable
		Product product = null;

		// Handler error with try - catch - finally
		try {

			// Open Hibernate session
			this.openSession();

			// Find product
			product = this.session.find(Product.class, id);

		} finally {
			// Close Hibernate session
			this.closeSession();
		}

		// Return result
		return product;
	}

	/**
	 * Get product by code
	 *
	 * @param code Product code
	 *
	 * @return Product
	 */
	public Product getProduct(String code) {

		// Declare result variable
		Product product = null;

		// Handler error with try - catch - finally
		try {

			// Open Hibernate session
			this.openSession();

			// Find product
			Query<Product> query = this.session.createQuery("from Product where code = :code", Product.class);
			query.setParameter("code", code);
			product = query.uniqueResult();

		} finally {
			// Close Hibernate session
			this.closeSession();
		}

		// Return result
		return product;
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
