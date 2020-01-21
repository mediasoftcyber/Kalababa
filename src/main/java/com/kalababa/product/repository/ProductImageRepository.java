package com.kalababa.product.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kalababa.product.entity.ProductImageEntity;

@Repository("ProdImgRepo")
public interface ProductImageRepository extends JpaRepository<ProductImageEntity, Serializable> {

	@Query(name = "from ProductImageEntity pie where pie.prodId=:prodId and pie.catId=catId order by imgId")
	List<ProductImageEntity> findAllByProdIdAndCatId(Integer prodId, Integer catId);
}
