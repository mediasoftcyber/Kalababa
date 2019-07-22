package com.kalababa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kalababa.model.BillingAddress;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Serializable> {

}
