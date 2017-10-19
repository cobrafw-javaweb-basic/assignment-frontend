/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: LoginController.java
 *== Created at: Oct 18, 2017 11:02:57 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.controllers
 */
package vn.edu.ploy.duongnv21.controllers;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import vn.edu.ploy.duongnv21.common.CommonConst;
import vn.edu.ploy.duongnv21.dao.AuthenticateDao;
import vn.edu.ploy.duongnv21.model.Account;

/**
 * Assignment Demo -> LoginController
 *
 * @author duongnguyen
 */
public class LoginController extends HttpServlet {

	/** Serial Version UID */
	private static final long serialVersionUID = -7956327845329936521L;

	/** Authenticate Data Accessing Object */
	private AuthenticateDao authenticateDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	/**
	 * @see GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {

		// Instance new DAO
		this.authenticateDao = new AuthenticateDao();
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

		// Get logged in account from session
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute(CommonConst.SESSION_ATTRIBUTE_ACCOUNT);

		// Check logged in account
		if (account != null) {
			// Return to default path
			response.sendRedirect(request.getContextPath() + CommonConst.AUTHETICATE_RETURN_PATH);
			return;
		}

		// Forward to login page
		RequestDispatcher dispatcher = request.getServletContext()
														.getRequestDispatcher("/views/auth/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set encoding
		request.setCharacterEncoding(CommonConst.REQEUST_CHARACTER_ENCODING_UTF8);

		// Invalid old session
		HttpSession session = request.getSession();
		session.removeAttribute(CommonConst.SESSION_ATTRIBUTE_ACCOUNT);

		// Get parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Validate parameters
		boolean hasInvalid = false;
		if (StringUtils.isEmpty(username)) { // Validate username
			request.setAttribute("errUsername", "Username is reuqired field.");
			hasInvalid = true;
		}
		if (StringUtils.isEmpty(password)) { // Validate password
			request.setAttribute("errPassword", "Password is reuqired field.");
			hasInvalid = true;
		}
		if (hasInvalid) { // Check invalid flag

			// Set invalid flash
			request.setAttribute("hasInvalid", true);

			// Forward to login page with invalid message
			RequestDispatcher dispatcher = request.getServletContext()
															.getRequestDispatcher("/views/auth/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// Query account from database
		Account account = this.authenticateDao
										.getLoginAccount(username, password, CommonConst.USER_TYPE_ADMIN);

		// Check result
		if (account == null) {

			// Add error message
			request.setAttribute("hasError", true);

			// Forward to login page with error message
			RequestDispatcher dispatcher = request.getServletContext()
															.getRequestDispatcher("/views/auth/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// Set session data
		session.setAttribute(CommonConst.SESSION_ATTRIBUTE_ACCOUNT, account);

		// Return to default path
		response.sendRedirect(request.getContextPath() + CommonConst.AUTHETICATE_RETURN_PATH);
		return;
	}
}
