package com.kalababa.service;

import java.util.List;

import com.kalababa.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	Product getProductById(Integer productId);

	void deleteProduct(Integer productId);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
}
