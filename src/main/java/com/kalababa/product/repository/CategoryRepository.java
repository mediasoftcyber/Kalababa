package com.kalababa.product.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kalababa.product.entity.CategoryMasterEntity;

public interface CategoryRepository extends JpaRepository<CategoryMasterEntity, Serializable> {

	@Query(name = "from CategoryMasterEntity cme where cme.hsnCode=:hsnCode")
	CategoryMasterEntity findByHsnCode(Integer hsnCode);

}
