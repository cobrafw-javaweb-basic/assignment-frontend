/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: IndexController.java
 *== Created at: Oct 20, 2017 1:57:28 AM
 *== Created by: duongnguyen
 *== Project: assignment-frontend
 *== Package: vn.edu.ploy.duongnv21.controllers
 */
package vn.edu.ploy.duongnv21.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.ploy.duongnv21.common.CommonConst;
import vn.edu.ploy.duongnv21.dao.CategoryDao;
import vn.edu.ploy.duongnv21.dao.ProductDao;
import vn.edu.ploy.duongnv21.model.Category;
import vn.edu.ploy.duongnv21.model.Product;

/**
 * Assignment Demo -> IndexController
 *
 * @author duongnguyen
 */
public class IndexController extends HttpServlet {

	/** Serial Version UID */
	private static final long serialVersionUID = -5121863561715102349L;

	/** Category Data Accessing Object */
	private CategoryDao categoryDao;

	/** Product Data Accessing Object */
	private ProductDao productDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexController() {
		super();
	}

	/**
	 * @see GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {

		// Instance new DAO
		this.categoryDao		= new CategoryDao();
		this.productDao		= new ProductDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set encoding
		request.setCharacterEncoding(CommonConst.REQEUST_CHARACTER_ENCODING_UTF8);

		// Get data from database
		List<Category> listCategories = this.categoryDao.getListCategories();
		List<Product> listProducts = this.productDao.getListProduct();

		// Set data into request scope
		request.setAttribute("listCategories", listCategories);
		request.setAttribute("listProducts", listProducts);

		// Redirect to list categories JSP
		RequestDispatcher dispatcher = request.getServletContext()
														.getRequestDispatcher("/views/index.jsp");
		dispatcher.forward(request, response);
	}
}
