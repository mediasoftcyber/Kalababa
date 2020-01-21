package com.kalababa.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "PRODUCT_IMAGE")
@Data
public class ProductImageEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IMG_ID")
	private Integer imageId;
	
	@Column(name="PROD_ID")
	private Integer prodId;
	
	@Column(name = "CAT_ID")
	private Integer catId;
	
	@Column(name = "IMAGE_NAME")
	private String imageName;
	
	@Column(name = "IMAGE_REAL_PATH")
	private String imageRealPath;
	
	@Column(name = "IMAGE_URL")
	private String imageUrl;
}
