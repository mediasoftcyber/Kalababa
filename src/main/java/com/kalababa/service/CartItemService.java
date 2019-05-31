package com.kalababa.service;

import com.kalababa.model.Cart;
import com.kalababa.model.CartItem;

public interface CartItemService {

	void addCartItem(CartItem cartItem);
	void removeCartItem(String CartItemId);
	void removeAllCartItems(Cart cart);
}
