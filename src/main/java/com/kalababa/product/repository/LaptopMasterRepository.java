package com.kalababa.product.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kalababa.product.entity.LaptopMasterEntity;

@Repository("laptopMasterRepo")
public interface LaptopMasterRepository extends JpaRepository<LaptopMasterEntity, Serializable>{

	@Query(name = "from LaptopMasterEntity lme where lme.custId=:custId order by prodId")
	List<LaptopMasterEntity> findByCustId(String custId);

	@Query(name = "from LaptopMasterEntity lme where lme.custId=:custId")
	void deleteByCustId(String custId);
	
}
