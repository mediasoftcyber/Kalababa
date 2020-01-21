package com.kalababa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalababa.model.Cart;
import com.kalababa.model.CartItem;
import com.kalababa.repository.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

	
	@Autowired
	private CartItemRepository cartItemRepo;

	public void addCartItem(CartItem cartItem) {
		cartItemRepo.save(cartItem);

	}
	
	@Override
	public void removeCartItem(Integer CartItemId) {
		cartItemRepo.deleteById(CartItemId);
	}
	
	@Override
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItem();
		for (CartItem cartItem : cartItems) {
			removeCartItem(cartItem.getCartItemId());
		}
	}

}
