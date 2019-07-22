package com.kalababa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalababa.model.Cart;
import com.kalababa.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;

	public Cart getCartByCartId(Integer CartId) {

		return cartRepo.findById(CartId).get();
	}

}
