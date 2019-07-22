package com.kalababa.product.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT_MASTER")
public class ProductMasterEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROD_ID")
	private Integer prodId;
	
	@Column(name = "CUST_ID")
	private String custId;
	
	@Column(name = "HSN_CODE")
	private Integer hsnCode;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "ITEM_MODEL_NUMBER")
	private String itemModelNumber;
	
	@Column(name = "COLOUR")
	private String colour;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "MRP")
	private Double mrp;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "SELLING_PRICE")
	private Double sellingPrice;
	
	@Column(name = "PURCHAGING_PRICE")
	private Double purchagingPrice;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name = "ACTIVE")	
	private Boolean active;
	
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="WARRANTY_PERIOD")
	private Integer warrantyPeriod;
	
	@Column(name = "WARRANTY_STATUS")
	private String warrantyStatus;
	
	@Column(name = "WARRANTY_START_DATE")
	private Date warrantyStartDate;
	
	@Column(name = "SELLING_DATE")
	private Date sellingDate;
	
	@Column(name = "SOLD")
	private Boolean sold;
	
	@CreationTimestamp
	@Column(name = "CREATE_DT")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "UPDATE_DT")
	private Date updateDate;
	
	
	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

}
