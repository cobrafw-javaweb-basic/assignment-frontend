/*
 *==================================================================================
 *== COPYRIGHT HYPERTECH COBRA TEAM. ALL RIGHT RESERVED.							==
 *== HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.		==
 *==																				==
 *== VISIT HTTP://COBRAFW.IO FOR MORE INFORMATION									==
 *==================================================================================
 *
 *== File Name: Product.java
 *== Created at: Oct 18, 2017 10:07:30 PM
 *== Created by: duongnguyen
 *== Project: assignment-backend
 *== Package: vn.edu.ploy.duongnv21.model
 */
package vn.edu.ploy.duongnv21.model;

/**
 * Assignment Demo -> Products
 *
 * @author duongnguyen
 */
public class Product implements java.io.Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = -5172257131752637309L;

	/** Products.ID */
	private Integer id;

	/** Products.CategoryId */
	private Integer categoryId;

	/** Products.Code */
	private String code;

	/** Products.Name */
	private String name;

	/** Products.UnitPrice */
	private Integer unitPrice;

	/** Products.Image */
	private String image;

	/** Products.Description */
	private String description;

	/** Products.Status */
	private String status;

	/** Product category */
	private Category category;

	/**
	 * Default constructor
	 */
	public Product() {
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
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return this.categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the unitPrice
	 */
	public Integer getUnitPrice() {
		return this.unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return this.image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
}
