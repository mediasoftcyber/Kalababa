package com.kalababa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "query")
@Data
public class Queries {

	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator = "id")
	private Integer id;

	private String email;
	private String subject;
	private String message;

	

}
