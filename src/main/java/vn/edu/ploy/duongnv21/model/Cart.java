/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: Cart.java
 *== Created at: Oct 18, 2017 10:08:07 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.model
 */
package vn.edu.ploy.duongnv21.model;

/**
 * Assignment Demo -> Carts
 *
 * @author duongnguyen
 */
public class Cart implements java.io.Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = -5648026412226790574L;

	/** Carts.ID */
	private Integer id;

	/** Carts.AccountId */
	private Integer accountId;

	/** Carts.TotalProducts */
	private Integer totalProducts;

	/** Carts.TotalPrice */
	private Integer totalPrice;

	/**
	 * Default constructor
	 */
	public Cart() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the accountId
	 */
	public Integer getAccountId() {
		return this.accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the totalProducts
	 */
	public Integer getTotalProducts() {
		return this.totalProducts;
	}

	/**
	 * @param totalProducts the totalProducts to set
	 */
	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}

	/**
	 * @return the totalPrice
	 */
	public Integer getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
}
