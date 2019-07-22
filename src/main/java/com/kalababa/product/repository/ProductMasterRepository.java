package com.kalababa.product.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kalababa.product.entity.ProductMasterEntity;

@Repository("productMasterRepo")
public interface ProductMasterRepository extends JpaRepository<ProductMasterEntity, Serializable>{

	@Query(name = "from ProductMasterEntity pme where pme.custId=:custId order by prodId")
	List<ProductMasterEntity> findByCustId(String custId);
	
	@Query(name = "from ProductMasterEntity pme where pme.custId=:custId")
	void deleteByCustId(String custId);

}
