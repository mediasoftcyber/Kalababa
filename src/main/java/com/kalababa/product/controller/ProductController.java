package com.kalababa.product.controller;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kalababa.constants.AppConstants;
import com.kalababa.product.entity.CategoryMasterEntity;
import com.kalababa.product.model.CameraMaster;
import com.kalababa.product.model.CategoryMaster;
import com.kalababa.product.model.LaptopMaster;
import com.kalababa.product.model.ProductMaster;
import com.kalababa.product.model.TVMaster;
import com.kalababa.product.service.ProductService;
import com.kalababa.properties.AppProperties;

@Controller
public class ProductController {

	private static Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired(required = true)
	private ProductService prodService;

	@Autowired
	private AppProperties appProperties;

	/**
	 * This is for showing product adding form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/addProduct", method = RequestMethod.GET)
	public String addProdForm(Model model) {
		logger.debug("ProductController::addProdForm() started");
		ProductMaster prodModel = new ProductMaster();
		model.addAttribute("prodModel", prodModel);
		logger.debug("ProductController::addProdForm() ended");
		logger.info("Product Adding Form loaded Successfully");
		return "addProd";
	}

	/**
	 * This is for Post back request for Adding Product
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/addProduct", method = RequestMethod.POST)
	public String addProd(@ModelAttribute("prodModel") ProductMaster prodModel, Model model, HttpServletRequest req) {
		logger.debug("ProductController::addProd() started");
		// call Service layer method
		int imgId = 0;
		String path = null;
		String realPath = null;
		ServletContext sc = req.getServletContext();
		Map<String, String> map = appProperties.getProperties();
		try {
			prodModel = prodService.addProduct(prodModel);
			MultipartFile[] files = prodModel.getImages();
			for (MultipartFile file : files) {
				path = "WEB-INF/classes/static/resource/images/products/prod_" + prodModel.getProdId() + "_img_"
						+ (++imgId) + ".jpg";
				realPath = sc.getRealPath(path);
				file.transferTo(new File(realPath));
				logger.info("Product Images transfered Successfully");
			}
			model.addAttribute(AppConstants.SUCCESS, map.get(AppConstants.PRODUCT_ADDITION_SUCCESS));
		} catch (Exception e) {
			model.addAttribute(AppConstants.FAILURE, map.get(AppConstants.PRODUCT_ADDITION_FAILURE)+" "+e.toString()+" "+realPath);
			logger.error("Error in Adding Product", e);
		}

		logger.debug("ProductController::addProd() ended");
		logger.info("Product Added Successfully");
		return "addProd";
	}

	@RequestMapping(path = "/addLaptop", method = RequestMethod.GET)
	public String addLaptopForm(HttpServletRequest req, Model model) {
		logger.debug("ProductController::addLaptopForm() started");
		LaptopMaster laptopModel = null;

		laptopModel = new LaptopMaster();
		List<CategoryMaster> categoryList = prodService.findAllCategories();
		for(CategoryMaster cat:categoryList){
			String categoryName =cat.getCategoryName().toLowerCase(); 
			if(categoryName.contains("laptop"))
				laptopModel.setHsnCode(cat.getHsnCode());
		}
		model.addAttribute("laptopModel", laptopModel);
		initProdForm(model);
		logger.debug("ProductController::addLaptopForm() ended");
		logger.info("Laptop Form created Successfully");
		return "addLaptop";
	}

	/**
	 * This method is used to load boolean list
	 * 
	 * @param model
	 */
	private void initProdForm(Model model) {

		Map<Boolean, String> boolList = new LinkedHashMap<>();
		boolList.put(false, "No");
		boolList.put(true, "Yes");
		model.addAttribute("boolList", boolList);
	}

	/**
	 * This is for showing product adding form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/addLaptop", method = RequestMethod.POST)
	public String addLaptop(@ModelAttribute("laptopModel") LaptopMaster laptopModel, Model model,
			HttpServletRequest req) {
		logger.debug("ProductController::addLaptop() started");
		// call Service layer method
		int imgId = 0;
		String path = null;
		String realPath = null;
		ServletContext sc = req.getServletContext();
		Map<String, String> map = appProperties.getProperties();
		try {
			laptopModel = prodService.addLaptop(laptopModel);
			MultipartFile[] files = laptopModel.getImages();
			for (MultipartFile file : files) {
				path = "WEB-INF/classes/static/resource/images/products/laptop_" + laptopModel.getProdId()
						+ "_img_" + (++imgId) + ".jpg";
				realPath = sc.getRealPath(path);
				file.transferTo(new File(realPath));
				logger.info("Product Images transfered Successfully");
			}
			model.addAttribute(AppConstants.SUCCESS, map.get(AppConstants.PRODUCT_ADDITION_SUCCESS)+" "+realPath);
		} catch (Exception e) {
			model.addAttribute(AppConstants.FAILURE, map.get(AppConstants.PRODUCT_ADDITION_FAILURE)+" "+e.toString()+" "+realPath);
			logger.error("Error in Adding Laptop", e);
		}

		model.addAttribute("laptopModel", laptopModel);
		initProdForm(model);
		logger.debug("ProductController::addLaptop() ended");
		logger.info("ProductController: Laptop Added Successfully");
		return "addLaptop";
	}

	/**
	 * This is for showing tv adding form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/addTV", method = RequestMethod.GET)
	public String addTVForm(HttpServletRequest req, Model model) {
		logger.debug("ProductController::addTVForm() started");
		TVMaster tvModel = new TVMaster();
		List<CategoryMaster> categoryList = prodService.findAllCategories();
		for(CategoryMaster cat:categoryList){
			String categoryName =cat.getCategoryName().toLowerCase(); 
			if(categoryName.contains("tv") || categoryName.contains("television"))
				tvModel.setHsnCode(cat.getHsnCode());
		}
		model.addAttribute("tvModel", tvModel);
		initProdForm(model);
		logger.debug("ProductController::addTVForm() ended");
		logger.info("TV Form created Successfully");
		return "addTV";
	}

	/**
	 * This is for adding TV
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/addTV", method = RequestMethod.POST)
	public String addTV(@ModelAttribute("tvModel") TVMaster tvModel, Model model, HttpServletRequest req) {
		logger.debug("ProductController::addTV() started");
		// call Service layer method
		int imgId = 0;
		ServletContext sc = req.getServletContext();
		Map<String, String> map = appProperties.getProperties();
		try {
			tvModel = prodService.addTV(tvModel);
			MultipartFile[] files = tvModel.getImages();
			for (MultipartFile file : files) {
				String path = "WEB-INF/classes/static/resource/images/products/tv_" + tvModel.getProdId()
						+ "_img_" + (++imgId) + ".jpg";
				String realPath = sc.getRealPath(path);
				file.transferTo(new File(realPath));
				logger.info("Product Images transfered Successfully");
			}
			model.addAttribute(AppConstants.SUCCESS, map.get(AppConstants.PRODUCT_ADDITION_SUCCESS));
		} catch (Exception e) {
			model.addAttribute(AppConstants.FAILURE, map.get(AppConstants.PRODUCT_ADDITION_FAILURE));
			logger.error("Error in Adding TV", e);
		}

		model.addAttribute("tvModel", tvModel);
		initProdForm(model);
		logger.debug("ProductController::addTV() ended");
		return "addTV";
	}

	/**
	 * This is for showing Camera adding form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/addCamera", method = RequestMethod.GET)
	public String addCameraForm(HttpServletRequest req, Model model) {
		logger.debug("ProductController::addCameraForm() started");
		CameraMaster cameraModel = null;
		cameraModel = new CameraMaster();
		List<CategoryMaster> categoryList = prodService.findAllCategories();
		for(CategoryMaster cat:categoryList){
			String categoryName =cat.getCategoryName().toLowerCase(); 
			if(categoryName.contains("camera") || categoryName.contains("cctv"))
				cameraModel.setHsnCode(cat.getHsnCode());
		}
		model.addAttribute("camModel", cameraModel);
		initProdForm(model);
		logger.debug("ProductController::addCameraForm() ended");
		logger.info("Camera Form created Successfully");
		return "addCamera";
	}

	/**
	 * This is for adding product
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/addCamera", method = RequestMethod.POST)
	public String addCamera(@ModelAttribute("camModel") CameraMaster cameraModel, Model model, HttpSession session,
			HttpServletRequest req) {
		logger.debug("ProductController::addCamera() started");
		// call Service layer method
				int imgId = 0;
				ServletContext sc = req.getServletContext();
				Map<String, String> map = appProperties.getProperties();
				try {
					cameraModel = prodService.addCamera(cameraModel);
					MultipartFile[] files = cameraModel.getImages();
					for (MultipartFile file : files) {
						String path = "WEB-INF/classes/static/resource/images/products/cam_" + cameraModel.getProdId()
								+ "_img_" + (++imgId) + ".jpg";
						String realPath = sc.getRealPath(path);
						file.transferTo(new File(realPath));
						logger.info("Product Images transfered Successfully");
					}
					model.addAttribute(AppConstants.SUCCESS, map.get(AppConstants.PRODUCT_ADDITION_SUCCESS));
				} catch (Exception e) {
					model.addAttribute(AppConstants.FAILURE, map.get(AppConstants.PRODUCT_ADDITION_FAILURE));
					logger.error("Error in Adding Camera", e);
				}

				model.addAttribute("camModel", cameraModel);
				initProdForm(model);
		logger.debug("ProductController::addCamera() ended");

		return "addCamera";
	}

	/**
	 * This is for showing category adding form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/addCategory", method = RequestMethod.GET)
	public String addCategoryForm(Model model) {
		logger.debug("ProductController::addCategoryForm() started");
		CategoryMaster categoryModel = new CategoryMaster();
		model.addAttribute("categoryModel", categoryModel);
		List<CategoryMaster> catList = prodService.findAllCategories();
		Map<Integer, String> categoryList = new LinkedHashMap<>();
		if (!catList.isEmpty()) {
			catList.forEach(cat -> {
				categoryList.put(cat.getHsnCode(), cat.getCategoryName());
			});
		}
		model.addAttribute("categoryList", categoryList);
		logger.debug("ProductController::addCategoryForm() ended");
		logger.info("Category Form created Successfully");
		return "addCategory";
	}

	/**
	 * This is for adding category
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/addCategory", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("categoryModel") CategoryMaster categoryModel, Model model) {
		logger.debug("ProductController::addCategory() started");
		CategoryMasterEntity entity = new CategoryMasterEntity();
		BeanUtils.copyProperties(categoryModel, entity);
		boolean isSaved = prodService.addCategory(entity);
		if (isSaved)
			model.addAttribute("success", "Category Added");
		else
			model.addAttribute("failure", "Category Addition Failed");
		List<CategoryMaster> catList = prodService.findAllCategories();
		Map<Integer, String> categoryList = new LinkedHashMap<>();
		if (!catList.isEmpty()) {
			catList.forEach(cat -> {
				categoryList.put(cat.getHsnCode(), cat.getCategoryName());
			});
		}
		model.addAttribute("categoryList", categoryList);
		logger.info("Category added Successfully");
		logger.debug("ProductController::addCategory() ended");
		return "addCategory";
	}

}
