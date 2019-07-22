package com.kalababa.product.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.kalababa.product.entity.CameraMasterEntity;
import com.kalababa.product.entity.CategoryMasterEntity;
import com.kalababa.product.entity.LaptopMasterEntity;
import com.kalababa.product.entity.ProductMasterEntity;
import com.kalababa.product.entity.TVMasterEntity;
import com.kalababa.product.model.CameraMaster;
import com.kalababa.product.model.CategoryMaster;
import com.kalababa.product.model.LaptopMaster;
import com.kalababa.product.model.ProductMaster;
import com.kalababa.product.model.TVMaster;
import com.kalababa.product.repository.CameraMasterRepository;
import com.kalababa.product.repository.CategoryRepository;
import com.kalababa.product.repository.LaptopMasterRepository;
import com.kalababa.product.repository.ProductMasterRepository;
import com.kalababa.product.repository.TVMasterRepository;

@Service("prodServiceImpl")
public class ProductServiceImpl implements ProductService {

	private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired(required = true)
	private ProductMasterRepository prodRepo;

	@Autowired(required = true)
	private LaptopMasterRepository lapRepo;
	
	@Autowired(required = true)
	private TVMasterRepository tvRepo;
	
	@Autowired(required = true)
	private CameraMasterRepository camRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	/**
	 * This method is for adding product
	 * 
	 * @param prodModel
	 * @return
	 * @throws Exception
	 */
	@Override
	public ProductMaster addProduct(ProductMaster prodModel) throws Exception {
		logger.debug("productService::addProduct() method started");
		// getting user name
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		prodModel.setCreatedBy(currentPrincipalName);
		prodModel.setUpdatedBy(currentPrincipalName);
		prodModel.setActive(true);
		if (prodModel.getWarrantyPeriod() == 0)
			prodModel.setWarrantyStatus("N/A");
		else
			prodModel.setWarrantyStatus("Available");
		prodModel.setWarrantyStartDate(new Date());
		Integer categoryId = categoryRepo.findByHsnCode(prodModel.getHsnCode()).getCategoryId();
		prodModel.setCategoryId(categoryId);

		// Convert model data to Entity data
		ProductMasterEntity entity = new ProductMasterEntity();
		BeanUtils.copyProperties(prodModel, entity);

		// Call Repository method
		entity = prodRepo.save(entity);

		BeanUtils.copyProperties(entity, prodModel);

		logger.info("Product added");
		logger.debug("productService::addProduct() completed");
		return prodModel;
	}

	/**
	 * This method is for adding Laptop
	 * 
	 * @param prodModel
	 * @return
	 * @throws Exception
	 */
	@Override
	public LaptopMaster addLaptop(LaptopMaster laptopModel) throws Exception {
		logger.debug("productService::addLaptop() method started");

		// getting user name
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		laptopModel.setCreatedBy(currentPrincipalName);
		laptopModel.setUpdatedBy(currentPrincipalName);
		laptopModel.setActive(true);
		laptopModel.setReplWarrantyStatus("Available");
		laptopModel.setServWarrantyStatus("Available");
		laptopModel.setWarrantyStartDate(new Date());
		Integer categoryId = categoryRepo.findByHsnCode(laptopModel.getHsnCode()).getCategoryId();
		laptopModel.setCategoryId(categoryId);

		// Convert model data to Entity data
		LaptopMasterEntity entity = new LaptopMasterEntity();
		BeanUtils.copyProperties(laptopModel, entity);

		// Call Repository method
		entity = lapRepo.save(entity);

		BeanUtils.copyProperties(entity, laptopModel);

		logger.info("Laptop added");
		logger.debug("productService::addLaptop() completed");
		return laptopModel;
	}
	
	/**
	 * This method is for adding tv
	 * 
	 * @param prodModel
	 * @return
	 * @throws Exception
	 */
	@Override
	public TVMaster addTV(TVMaster tvModel) throws Exception {
		logger.debug("productService::addTV() method started");

		// getting user name
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		tvModel.setCreatedBy(currentPrincipalName);
		tvModel.setUpdatedBy(currentPrincipalName);
		tvModel.setActive(true);
		tvModel.setReplWarrantyStatus("Available");
		tvModel.setServWarrantyStatus("Available");
		tvModel.setWarrantyStartDate(new Date());
		Integer categoryId = categoryRepo.findByHsnCode(tvModel.getHsnCode()).getCategoryId();
		tvModel.setCategoryId(categoryId);

		// Convert model data to Entity data
		TVMasterEntity entity = new TVMasterEntity();
		BeanUtils.copyProperties(tvModel, entity);

		// Call Repository method
		entity = tvRepo.save(entity);

		BeanUtils.copyProperties(entity, tvModel);

		logger.info("TV added");
		logger.debug("productService::addTV() completed");
		return tvModel;
	}
	
	/**
	 * This method is for adding tv
	 * 
	 * @param prodModel
	 * @return
	 * @throws Exception
	 */
	@Override
	public CameraMaster addCamera(CameraMaster cameraModel) throws Exception {
		logger.debug("productService::addCamera() method started");

		// getting user name
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		cameraModel.setCreatedBy(currentPrincipalName);
		cameraModel.setUpdatedBy(currentPrincipalName);
		cameraModel.setActive(true);
		cameraModel.setWarrantyStatus("Available");
		cameraModel.setWarrantyStartDate(new Date());
		Integer categoryId = categoryRepo.findByHsnCode(cameraModel.getHsnCode()).getCategoryId();
		cameraModel.setCategoryId(categoryId);

		// Convert model data to Entity data
		CameraMasterEntity entity = new CameraMasterEntity();
		BeanUtils.copyProperties(cameraModel, entity);

		// Call Repository method
		entity = camRepo.save(entity);

		BeanUtils.copyProperties(entity, cameraModel);

		logger.info("Camera added");
		logger.debug("productService::addCamera() completed");
		return cameraModel;
	}

	@Override
	public LaptopMaster findLaptopByProdId(String prodId) throws Exception {
		LaptopMaster lapModel = new LaptopMaster();
		LaptopMasterEntity entity = lapRepo.getOne(prodId);
		BeanUtils.copyProperties(entity, lapModel);
		return lapModel;
	}

	/**
	 * This method is for finding all products by custId
	 */
	@Override
	public List<ProductMaster> findAllProdsByCustId(String custId) {
		logger.debug("CustomerService::findAllProdsByCustId() method started");
		List<ProductMasterEntity> listEntity = prodRepo.findByCustId(custId);
		List<ProductMaster> prodList = new ArrayList<>();
		listEntity.forEach(entity -> {
			ProductMaster prodModel = new ProductMaster();
			BeanUtils.copyProperties(entity, prodModel);
			prodList.add(prodModel);
		});
		logger.debug("CustomerService::findAllProdsByCustId() method ended");
		return prodList;
	}

	/**
	 * This method is for finding selling product by prodId
	 */
	@Override
	public ProductMaster findByProdId(String prodId) {
		logger.debug("CustomerService::findByProdId() method started");
		ProductMasterEntity entity = prodRepo.getOne(prodId);
		ProductMaster model = new ProductMaster();
		BeanUtils.copyProperties(entity, model);
		logger.debug("CustomerService::findAllProdsByCustId() method ended");
		return model;
	}

	/**
	 * This method is for finding all laptops by custId
	 */
	@Override
	public List<LaptopMaster> findAllLaptopsByCustId(String custId) {
		logger.debug("CustomerService::findAllLaptopsByCustId() method started");
		List<LaptopMasterEntity> listEntity = lapRepo.findByCustId(custId);
		List<LaptopMaster> modelList = new ArrayList<>();
		listEntity.forEach(entity -> {
			LaptopMaster lapModel = new LaptopMaster();
			BeanUtils.copyProperties(entity, lapModel);
			modelList.add(lapModel);
		});
		logger.debug("CustomerService::findAllLaptopsByCustId() method ended");
		return modelList;
	}

	/**
	 * This method is for finding all laptops by custId
	 */
	@Override
	public boolean deleteProductByPordId(String prodId) {
		logger.debug("CustomerService::deleteProductByPordId() method started");
		try {
			prodRepo.deleteById(prodId);
			logger.info("Product Deleted Successully");
			lapRepo.deleteById(prodId);
			logger.info("Laptop Deleted Successully");
			logger.debug("CustomerService::deleteProductByPordId() method ended");
			return true;
		} catch (Exception e) {
			logger.error("Error in Deleting Product" + e.getMessage());
		}

		return false;
	}

	/**
	 * This method is for adding category of product
	 */
	@Override
	public boolean addCategory(CategoryMasterEntity entity) {
		logger.debug("CustomerService::addCategory() method started");
		boolean isSaved = false;
		try {
			entity = categoryRepo.save(entity);
			isSaved = true;
			logger.info("Category added Successully");
			logger.debug("CustomerService::addCategory() method ended");
		} catch (Exception e) {
			logger.error("Error in Adding Product", e);
		}

		return isSaved;
	}

	/**
	 * This method is for adding category of product
	 */
	@Override
	public List<CategoryMaster> findAllCategories() {
		logger.debug("CustomerService::findAllCategories() method started");
		List<CategoryMasterEntity> entityList = null;
		try {
			entityList = categoryRepo.findAll();
		} catch (Exception e) {
			logger.error("Error in Retrieving Product" + e.getMessage());
		}

		List<CategoryMaster> categoryList = new ArrayList<>();
		entityList.forEach(entity -> {
			CategoryMaster categoryMaster = new CategoryMaster();
			BeanUtils.copyProperties(entity, categoryMaster);
			categoryList.add(categoryMaster);
		});
		logger.info("Category retrieved Successully");
		logger.debug("CustomerService::findAllCategories() method ended");
		return categoryList;

	}

	@Override
	public List<LaptopMaster> findAllLaptops() {
		List<LaptopMasterEntity> listEntity = lapRepo.findAll();
		List<LaptopMaster> listLaptop = new ArrayList<>();
		listEntity.forEach(entity->{
			LaptopMaster laptopMaster = new LaptopMaster();
			BeanUtils.copyProperties(entity, laptopMaster);
			listLaptop.add(laptopMaster);
		});
		return listLaptop;
	}

}
