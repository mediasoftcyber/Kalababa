package com.kalababa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kalababa.model.Cart;
import com.kalababa.model.CartItem;
import com.kalababa.model.Customer;
import com.kalababa.model.Product;
import com.kalababa.service.CartItemService;
import com.kalababa.service.CartService;
import com.kalababa.service.CustomerService;
import com.kalababa.service.ProductService;

@Controller
public class CartItemController {

	//@Autowired
	private CartService cartService;

	//@Autowired
	private CartItemService cartItemService;

	//@Autowired
	private CustomerService customerService;

	//@Autowired
	private ProductService productService;

	@RequestMapping("/cart/add")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addCartItem(@RequestParam(value = "productId") Integer productId) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		Customer customer = customerService.getCustomerByemailId(emailId);
		System.out.println("Customer : " + customer.getUsers().getEmailId());
		Cart cart = customer.getCart();
		System.out.println(cart);
		List<CartItem> cartItems = cart.getCartItem();
		Product product = productService.getProductById(productId);
		for (int i = 0; i < cartItems.size(); i++) {
			CartItem cartItem = cartItems.get(i);
			if (product.getProductId().equals(cartItem.getProduct().getProductId())) {
				cartItem.setQuality(cartItem.getQuality() + 1);
				cartItem.setPrice(cartItem.getQuality() * cartItem.getProduct().getProductPrice());
				cartItemService.addCartItem(cartItem);
				return;
			}
		}
		CartItem cartItem = new CartItem();
		cartItem.setQuality(1);
		cartItem.setProduct(product);
		cartItem.setPrice(product.getProductPrice() * 1);
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}

	@RequestMapping("/cart/removeCartItem")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCartItem(@RequestParam(value = "cartItemId") Integer cartItemId) {
		cartItemService.removeCartItem(cartItemId);
	}

	@RequestMapping("/cart/removeAllItems")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeAllCartItems(@RequestParam(value = "cartId") Integer cartId) {
		Cart cart = cartService.getCartByCartId(cartId);
		cartItemService.removeAllCartItems(cart);
	}

}
