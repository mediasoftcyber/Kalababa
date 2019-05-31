package com.kalababa.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductModel{
	private Integer productId;
	private String productCategory;
	private String productDescription;
	private String productManufacturer;
	private String productName;
	private double productPrice;
	private String unitStock;
	private MultipartFile productImage;
}
