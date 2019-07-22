package com.kalababa.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kalababa.model.Product;
import com.kalababa.repository.ProductRepository;

//@Transactional(propagation = Propagation.REQUIRED)
//@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;


	@Transactional
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	@Transactional
	public Product getProductById(Integer productId) {
		return prodRepo.findById(productId).get();
	}

	@Transactional
	public void deleteProduct(Integer productId) {
		prodRepo.deleteById(productId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
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
		prodRepo.save(product);
	}

}
