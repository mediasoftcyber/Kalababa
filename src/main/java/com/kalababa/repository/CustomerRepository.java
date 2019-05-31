package com.kalababa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kalababa.model.Customer;

@Repository("custRepo")
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

}
