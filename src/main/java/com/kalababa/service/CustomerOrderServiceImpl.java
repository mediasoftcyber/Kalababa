package com.kalababa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalababa.model.Cart;
import com.kalababa.model.CartItem;
import com.kalababa.model.CustomerOrder;

import co.kalababa.dao.CustomerOrderDao;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	//@Autowired
	private CustomerOrderDao customerOrderDao;
	
	//@Autowired
	private CartService cartService;
	
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDao.addCustomerOrder(customerOrder);
	}

	public double getCustomerOrderGrandTotal(Integer cartId) {
		double grandTotal=0;
		Cart cart = cartService.getCartByCartId(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		
		for(CartItem item: cartItems){
			grandTotal += item.getPrice();
		}
		return grandTotal;
	}

}
