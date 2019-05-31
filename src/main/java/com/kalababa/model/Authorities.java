package com.kalababa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name = "authorities")
public class Authorities implements Serializable {

	private static final long serialVersionUID = 8734140534986494039L;
	
	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator = "id")
	@Column(name = "AUTHORITYID")
	private Integer authorityId;
	@Column(name = "EMAILID")
	private String emailId;
	@Column(name = "AUTHORITIES")
	private String authorities;

	

}
