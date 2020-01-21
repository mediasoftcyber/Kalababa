package com.kalababa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Entity
@Table(name = "item")
@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 5186013952828648626L;

	@Id
	@Column(name = "Id")
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 500001)
	@GeneratedValue(generator = "mySeqGen")
	private Integer itemId;
	
	@Column(name = "PROD_ID")
	private Integer prodId;
	
	@Column(name="category_Id")
	private Integer categoryId;
	
	@Column(name = "PROD_TITLE")
	private String prodTitle;
}
