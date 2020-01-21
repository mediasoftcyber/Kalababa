package com.kalababa.product.service;

import java.util.List;

import javax.servlet.ServletContext;

import com.kalababa.model.Product;
import com.kalababa.product.entity.CategoryMasterEntity;
import com.kalababa.product.model.CameraMaster;
import com.kalababa.product.model.CategoryMaster;
import com.kalababa.product.model.LaptopMaster;
import com.kalababa.product.model.ProductMaster;
import com.kalababa.product.model.TVMaster;

public interface ProductService {
	
	public ProductMaster addProduct(ProductMaster prodModel, ServletContext sc)throws Exception;
	
	public LaptopMaster addLaptop(LaptopMaster laptopModel, ServletContext sc)throws Exception;

	public LaptopMaster findLaptopByProdId(Integer prodId)throws Exception;

	boolean deleteProductByPordId(String prodId);

	List<LaptopMaster> findAllLaptopsByCustId(String custId);

	ProductMaster findByProdId(Integer prodId)throws Exception;

	List<ProductMaster> findAllProdsByCustId(String custId);

	boolean addCategory(CategoryMasterEntity entity);

	List<CategoryMaster> findAllCategories();
	CategoryMaster findCategoryByCategoryId(Integer catId);

	public TVMaster addTV(TVMaster tvModel, ServletContext sc)throws Exception;
	
	public TVMaster findTVByProdId(Integer prodId)throws Exception;

	public CameraMaster addCamera(CameraMaster cameraModel, ServletContext sc)throws Exception;

	public List<LaptopMaster> findAllLaptops();

	public CameraMaster findCamByProdId(Integer prodId)throws Exception;

	public List<TVMaster> findAllTV();

	public List<CameraMaster> findAllCamera();

	public List<ProductMaster> findAllProducts();

	public List<Product> findAllItems();

	



	
}
