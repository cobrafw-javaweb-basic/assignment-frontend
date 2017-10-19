/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: Category.java
 *== Created at: Oct 18, 2017 10:07:21 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.model
 */
package vn.edu.ploy.duongnv21.model;

import java.util.Set;

/**
 * Assignment Demo -> Categories
 *
 * @author duongnguyen
 */
public class Category implements java.io.Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 707174207739109673L;

	/** Categories.Id */
	private Integer id;

	/** Categories.FatherId */
	private Integer fatherId;

	/** Categories.Name */
	private String name;

	/** Categories.SortNo */
	private Integer sortNo;

	/** Parent category */
	private Category category;

	/** Sub categories */
	private Set<Category> subCategories;

	/**
	 * Default constructor
	 */
	public Category() {
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
	 * @return the fatherId
	 */
	public Integer getFatherId() {
		return this.fatherId;
	}

	/**
	 * @param fatherId the fatherId to set
	 */
	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sortNo
	 */
	public Integer getSortNo() {
		return this.sortNo;
	}

	/**
	 * @param sortNo the sortNo to set
	 */
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return this.category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the subCategories
	 */
	public Set<Category> getSubCategories() {
		return this.subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}
}
