package com.kalababa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kalababa.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable> {

	@Query(name = "from Product p where p.prodId=:prodId")
	List<Product> findAllByProdId(Integer prodId);
}
