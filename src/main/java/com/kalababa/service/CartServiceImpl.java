package com.kalababa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalababa.model.Cart;

import co.kalababa.dao.CartDao;

@Service
public class CartServiceImpl implements CartService {

	//@Autowired
	private CartDao cartDao;

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public Cart getCartByCartId(String CartId) {

		return cartDao.getCartByCartId(CartId);
	}

}
