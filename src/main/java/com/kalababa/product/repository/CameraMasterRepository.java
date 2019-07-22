package com.kalababa.product.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kalababa.product.entity.CameraMasterEntity;

@Repository("camMasterRepo")
public interface CameraMasterRepository extends JpaRepository<CameraMasterEntity, Serializable>{

	@Query(name = "from CameraMasterEntity lme where lme.custId=:custId order by prodId")
	List<CameraMasterEntity> findByCustId(String custId);

	@Query(name = "from CameraMasterEntity lme where lme.custId=:custId")
	void deleteByCustId(String custId);
	
}
