package com.kalababa.product.service;

import java.util.List;

import com.kalababa.product.entity.CategoryMasterEntity;
import com.kalababa.product.model.CameraMaster;
import com.kalababa.product.model.CategoryMaster;
import com.kalababa.product.model.LaptopMaster;
import com.kalababa.product.model.ProductMaster;
import com.kalababa.product.model.TVMaster;

public interface ProductService {
	
	public ProductMaster addProduct(ProductMaster prodModel)throws Exception;
	
	public LaptopMaster addLaptop(LaptopMaster laptopModel)throws Exception;

	public LaptopMaster findLaptopByProdId(String prodId)throws Exception;

	boolean deleteProductByPordId(String prodId);

	List<LaptopMaster> findAllLaptopsByCustId(String custId);

	ProductMaster findByProdId(String prodId);

	List<ProductMaster> findAllProdsByCustId(String custId);

	boolean addCategory(CategoryMasterEntity entity);

	List<CategoryMaster> findAllCategories();

	public TVMaster addTV(TVMaster tvModel)throws Exception;

	public CameraMaster addCamera(CameraMaster cameraModel)throws Exception;

	public List<LaptopMaster> findAllLaptops();

	



	
}
