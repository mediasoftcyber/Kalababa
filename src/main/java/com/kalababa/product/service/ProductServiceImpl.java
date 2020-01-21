package com.kalababa.product.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kalababa.model.Product;
import com.kalababa.product.entity.CameraMasterEntity;
import com.kalababa.product.entity.CategoryMasterEntity;
import com.kalababa.product.entity.LaptopMasterEntity;
import com.kalababa.product.entity.ProductImageEntity;
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
import com.kalababa.product.repository.ProductImageRepository;
import com.kalababa.product.repository.ProductMasterRepository;
import com.kalababa.product.repository.TVMasterRepository;
import com.kalababa.repository.ProductRepository;

@Service("prodServiceImpl")
public class ProductServiceImpl implements ProductService {

	private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired(required = true)
	private ProductMasterRepository prodMasterRepo;

	@Autowired(required = true)
	private LaptopMasterRepository lapRepo;

	@Autowired(required = true)
	private TVMasterRepository tvRepo;

	@Autowired(required = true)
	private CameraMasterRepository camRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ProductImageRepository prodImgRepo;

	@Autowired
	private ProductRepository prodRepo;

	/**
	 * This method is for adding product
	 * 
	 * @param prodModel
	 * @return
	 * @throws Exception
	 */
	@Override
	public ProductMaster addProduct(ProductMaster prodModel, ServletContext sc) throws Exception {
		logger.debug("productService::addProduct() method started");

		int imgId = 0;
		String path = null;
		String realPath = null;

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
		entity = prodMasterRepo.save(entity);
		BeanUtils.copyProperties(entity, prodModel);

		// saving images and storing image data into ProductImage table
		try {
			MultipartFile[] files = prodModel.getImages();
			for (MultipartFile file : files) {
				String fileName = "prod_" + prodModel.getProdId() + "_img_" + (++imgId) + ".jpg";
				path = "WEB-INF/classes/static/resource/images/products/" + fileName;
				realPath = sc.getRealPath(path);
				file.transferTo(new File(realPath));
				logger.info("Product Images transfered Successfully to " + realPath);
				ProductImageEntity prodImgEntity = new ProductImageEntity();
				prodImgEntity.setImageName(fileName);
				prodImgEntity.setImageUrl("resource/images/products/" + fileName);
				prodImgEntity.setImageRealPath(realPath);
				prodImgEntity.setProdId(prodModel.getProdId());
				prodImgEntity.setCatId(prodModel.getCategoryId());
				prodImgRepo.save(prodImgEntity);
			}
		} catch (Exception e) {
			logger.info("Product Images transfer failed", e);
			throw e;
		}
		for (int i = 0; i < entity.getQuantity(); i++) {
			Product product = new Product();
			product.setProdId(entity.getProdId());
			product.setProdTitle(entity.getTitle());
			product.setCategoryId(entity.getCategoryId());
			
			prodRepo.save(product);
		}
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
	public LaptopMaster addLaptop(LaptopMaster laptopModel, ServletContext sc) throws Exception {
		logger.debug("productService::addLaptop() method started");

		int imgId = 0;
		String path = null;
		String realPath = null;

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

		// saving images and storing image data into ProductImage table
		try {
			MultipartFile[] files = laptopModel.getImages();
			for (MultipartFile file : files) {
				String fileName = "laptop_" + laptopModel.getProdId() + "_img_" + (++imgId) + ".jpg";
				path = "WEB-INF/classes/static/resource/images/products/" + fileName;
				realPath = sc.getRealPath(path);
				file.transferTo(new File(realPath));
				logger.info("Product Images transfered Successfully to " + realPath);
				ProductImageEntity prodImgEntity = new ProductImageEntity();
				prodImgEntity.setImageName(fileName);
				prodImgEntity.setImageUrl("resource/images/products/" + fileName);
				prodImgEntity.setImageRealPath(realPath);
				prodImgEntity.setProdId(laptopModel.getProdId());
				prodImgEntity.setCatId(laptopModel.getCategoryId());
				prodImgRepo.save(prodImgEntity);
			}
		} catch (Exception e) {
			logger.info("Product Images transfer failed", e);
			throw e;
		}
		for (int i = 0; i < entity.getQuantity(); i++) {
			Product product = new Product();
			product.setProdId(entity.getProdId());
			product.setProdTitle(entity.getTitle());
			product.setCategoryId(entity.getCategoryId());
			
			prodRepo.save(product);
		}
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
	public TVMaster addTV(TVMaster tvModel, ServletContext sc) throws Exception {
		logger.debug("productService::addTV() method started");

		int imgId = 0;
		String path = null;
		String realPath = null;

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

		// saving images and storing image data into ProductImage table
		try {
			MultipartFile[] files = tvModel.getImages();
			for (MultipartFile file : files) {
				String fileName = "tv_" + tvModel.getProdId() + "_img_" + (++imgId) + ".jpg";
				path = "WEB-INF/classes/static/resource/images/products/" + fileName;
				realPath = sc.getRealPath(path);
				file.transferTo(new File(realPath));
				logger.info("Product Images transfered Successfully to " + realPath);
				ProductImageEntity prodImgEntity = new ProductImageEntity();
				prodImgEntity.setImageName(fileName);
				prodImgEntity.setImageUrl("resource/images/products/" + fileName);
				prodImgEntity.setImageRealPath(realPath);
				prodImgEntity.setProdId(tvModel.getProdId());
				prodImgEntity.setCatId(tvModel.getCategoryId());
				prodImgRepo.save(prodImgEntity);
			}
		} catch (Exception e) {
			logger.info("Product Images transfer failed", e);
			throw e;
		}
		for (int i = 0; i < entity.getQuantity(); i++) {
			Product product = new Product();
			product.setProdId(entity.getProdId());
			product.setProdTitle(entity.getTitle());
			product.setCategoryId(entity.getCategoryId());
			
			prodRepo.save(product);
		}
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
	public CameraMaster addCamera(CameraMaster cameraModel, ServletContext sc) throws Exception {
		logger.debug("productService::addCamera() method started");

		int imgId = 0;
		String path = null;
		String realPath = null;

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

		// saving images and storing image data into ProductImage table
		try {
			MultipartFile[] files = cameraModel.getImages();
			for (MultipartFile file : files) {
				String fileName = "cam_" + cameraModel.getProdId() + "_img_" + (++imgId) + ".jpg";
				path = "WEB-INF/classes/static/resource/images/products/" + fileName;
				realPath = sc.getRealPath(path);
				file.transferTo(new File(realPath));
				logger.info("Product Images transfered Successfully to " + realPath);
				ProductImageEntity prodImgEntity = new ProductImageEntity();
				prodImgEntity.setImageName(fileName);
				prodImgEntity.setImageUrl("resource/images/products/" + fileName);
				prodImgEntity.setImageRealPath(realPath);
				prodImgEntity.setProdId(cameraModel.getProdId());
				prodImgEntity.setCatId(cameraModel.getCategoryId());
				prodImgRepo.save(prodImgEntity);
			}
		} catch (Exception e) {
			logger.info("Product Images transfer failed", e);
			throw e;
		}
		for (int i = 0; i < entity.getQuantity(); i++) {
			Product product = new Product();
			product.setProdId(entity.getProdId());
			product.setProdTitle(entity.getTitle());
			product.setCategoryId(entity.getCategoryId());
			
			prodRepo.save(product);
		}
		logger.info("Camera added");
		logger.debug("productService::addCamera() completed");
		return cameraModel;
	}

	/**
	 * This method is for finding laptop by prodId
	 */
	@Override
	public LaptopMaster findLaptopByProdId(Integer prodId) throws Exception {
		LaptopMaster laptopMaster = new LaptopMaster();
		LaptopMasterEntity entity = lapRepo.findById(prodId).get();
		BeanUtils.copyProperties(entity, laptopMaster);
		List<ProductImageEntity> prodImgs = prodImgRepo.findAllByProdIdAndCatId(laptopMaster.getProdId(), laptopMaster.getCategoryId());
		laptopMaster.setProdImgs(prodImgs);
		return laptopMaster;
	}

	/**
	 * This method is for finding tv by prodId
	 */
	@Override
	public TVMaster findTVByProdId(Integer prodId) throws Exception {
		TVMaster tvMaster = new TVMaster();
		TVMasterEntity entity = tvRepo.findById(prodId).get();
		BeanUtils.copyProperties(entity, tvMaster);
		List<ProductImageEntity> prodImgs = prodImgRepo.findAllByProdIdAndCatId(tvMaster.getProdId(), tvMaster.getCategoryId());
		tvMaster.setProdImgs(prodImgs);
		return tvMaster;
	}

	/**
	 * This method is for finding camera by prodId
	 */
	@Override
	public CameraMaster findCamByProdId(Integer prodId) throws Exception {
		CameraMaster camMaster = new CameraMaster();
		TVMasterEntity entity = tvRepo.findById(prodId).get();
		BeanUtils.copyProperties(entity, camMaster);
		List<ProductImageEntity> prodImgs = prodImgRepo.findAllByProdIdAndCatId(camMaster.getProdId(), camMaster.getCategoryId());
		camMaster.setProdImgs(prodImgs);
		return camMaster;
	}

	/**
	 * This method is for finding product by prodId
	 */
	@Override
	public ProductMaster findByProdId(Integer prodId) throws Exception {
		logger.debug("CustomerService::findByProdId() method started");
		ProductMasterEntity entity = prodMasterRepo.getOne(prodId);
		ProductMaster model = new ProductMaster();
		BeanUtils.copyProperties(entity, model);
		List<ProductImageEntity> prodImgs = prodImgRepo.findAllByProdIdAndCatId(model.getProdId(),model.getCategoryId());
		model.setProdImgs(prodImgs);
		logger.debug("CustomerService::findAllProdsByCustId() method ended");
		return model;
	}

	/**
	 * This method is for finding all products by custId
	 */
	@Override
	public List<ProductMaster> findAllProdsByCustId(String custId) {
		logger.debug("CustomerService::findAllProdsByCustId() method started");
		List<ProductMasterEntity> listEntity = prodMasterRepo.findByCustId(custId);
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
			prodMasterRepo.deleteById(prodId);
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

	/**
	 * This method is for finding all Laptops
	 */
	@Override
	public List<LaptopMaster> findAllLaptops() {
		List<LaptopMasterEntity> listEntity = lapRepo.findAll();
		List<LaptopMaster> listLaptop = new ArrayList<>();
		listEntity.forEach(entity -> {
			LaptopMaster laptopMaster = new LaptopMaster();
			BeanUtils.copyProperties(entity, laptopMaster);
			List<ProductImageEntity> prodImgs = prodImgRepo.findAllByProdIdAndCatId(laptopMaster.getProdId(),laptopMaster.getCategoryId());
			laptopMaster.setProdImgs(prodImgs);
			listLaptop.add(laptopMaster);
		});
		return listLaptop;
	}
	
	/**
	 * This method is for finding all TVs
	 */
	@Override
	public List<TVMaster> findAllTV() {
		List<TVMasterEntity> listEntity = tvRepo.findAll();
		List<TVMaster> listTV = new ArrayList<>();
		listEntity.forEach(entity -> {
			TVMaster tvMaster = new TVMaster();
			BeanUtils.copyProperties(entity, tvMaster);
			List<ProductImageEntity> prodImgs = prodImgRepo.findAllByProdIdAndCatId(tvMaster.getProdId(), tvMaster.getCategoryId());
			tvMaster.setProdImgs(prodImgs);
			listTV.add(tvMaster);
		});
		return listTV;
	}
	
	/**
	 * This method is for finding all Cams
	 */
	@Override
	public List<CameraMaster> findAllCamera() {
		List<CameraMasterEntity> listEntity = camRepo.findAll();
		List<CameraMaster> listCam = new ArrayList<>();
		listEntity.forEach(entity -> {
			CameraMaster camMaster = new CameraMaster();
			BeanUtils.copyProperties(entity, camMaster);
			List<ProductImageEntity> prodImgs = prodImgRepo.findAllByProdIdAndCatId(camMaster.getProdId(), camMaster.getCategoryId());
			camMaster.setProdImgs(prodImgs);
			listCam.add(camMaster);
		});
		return listCam;
	}
	
	/**
	 * This method is for finding all Miscellaneous Products
	 */
	@Override
	public List<ProductMaster> findAllProducts() {
		List<ProductMasterEntity> listEntity = prodMasterRepo.findAll();
		List<ProductMaster> listProd = new ArrayList<>();
		listEntity.forEach(entity -> {
			ProductMaster prodMaster = new ProductMaster();
			BeanUtils.copyProperties(entity, prodMaster);
			List<ProductImageEntity> prodImgs = prodImgRepo.findAllByProdIdAndCatId(prodMaster.getProdId(), prodMaster.getCategoryId());
			prodMaster.setProdImgs(prodImgs);
			listProd.add(prodMaster);
		});
		return listProd;
	}
	
	/**
	 * This method is for finding all items
	 */
	@Override
	public List<Product> findAllItems() {
		return prodRepo.findAll();
	}
	
	@Override
	public CategoryMaster findCategoryByCategoryId(Integer catId) {
		CategoryMasterEntity entity = categoryRepo.findById(catId).get();
		CategoryMaster model = new CategoryMaster();
		BeanUtils.copyProperties(entity, model);
		return model;
	}

}
