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
@Table(name = "users")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 2681531852204068105L;
	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator = "id")
	private Integer userId;
	private String emailId;
	private String password;
	private boolean enabled;

	@OneToOne(mappedBy = "users")
	private Customer customer;

	

}
