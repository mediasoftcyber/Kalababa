package com.kalababa.product.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductMaster{

	private Integer prodId;
	private String custId;
	private Integer hsnCode;
	private String title;
	private String brand;
	private String itemModelNumber;
	private String colour;
	private String description;
	private Double mrp;
	private Double price;
	private Double sellingPrice;
	private Double purchagingPrice;
	private Integer quantity;
	private Boolean active;
	private Integer categoryId;
	private Integer warrantyPeriod;
	private String warrantyStatus;
	private Date warrantyStartDate;
	private Date sellingDate;
	private Boolean sold;
	private Date createDate;
	private Date updateDate;
	private String createdBy;
	private String updatedBy;
	private MultipartFile[] images;

}
