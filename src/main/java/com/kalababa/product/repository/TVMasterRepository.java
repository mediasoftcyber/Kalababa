package com.kalababa.product.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kalababa.product.entity.TVMasterEntity;

@Repository("tvMasterRepo")
public interface TVMasterRepository extends JpaRepository<TVMasterEntity, Serializable>{

	@Query(name = "from TVMasterEntity lme where lme.custId=:custId order by prodId")
	List<TVMasterEntity> findByCustId(String custId);

	@Query(name = "from TVMasterEntity lme where lme.custId=:custId")
	void deleteByCustId(String custId);
	
}
