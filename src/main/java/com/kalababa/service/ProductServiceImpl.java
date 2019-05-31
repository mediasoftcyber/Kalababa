package com.kalababa.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kalababa.model.Product;
import com.kalababa.repository.ProductRepository;

import co.kalababa.dao.ProductDao;

@Transactional(propagation = Propagation.REQUIRED)
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

	// @Autowired
	private ProductDao productDao;

	@Autowired
	private ProductRepository prodRepo;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Transactional
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	public Product getProductById(String productId) {
		return productDao.getProductById(productId);
	}

	public void deleteProduct(String productId) {
		productDao.deleteProduct(productId);
	}

	public void addProduct(Product product) {
		try {
			product = prodRepo.save(product);
			
			MultipartFile image = product.getProductImage();
			if (image != null && !image.isEmpty()) {
				//"E:/MediaSoft/Kalababa2/src/main/resources/static/resource/images/products/"
				//E:\MediaSoft\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\Kalababa
				///Kalababa2/src/main/resources/static/resource/images/products

				image.transferTo(new File("/MediaSoft/Kalababa2/src/main/resources/static/resource/images/products/"+product.getProductId() + ".jpg"));
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// productDao.addProduct(product);
	}

	public void editProduct(Product product) {
		productDao.editProduct(product);
	}

}
