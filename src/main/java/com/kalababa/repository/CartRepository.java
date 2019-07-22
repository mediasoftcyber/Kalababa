package com.kalababa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kalababa.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Serializable> {

}
