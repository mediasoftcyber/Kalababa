package com.kalababa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "shippingAddress")
@Data
public class ShippingAddress implements Serializable {

	private static final long serialVersionUID = 7551999649936522523L;

	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator = "id")
	private Integer shippingAddressId;

	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;

	@OneToOne(mappedBy = "shippingAddress")
	private Customer customer;

	
}
