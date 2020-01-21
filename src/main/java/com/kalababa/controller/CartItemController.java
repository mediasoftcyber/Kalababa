package com.kalababa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kalababa.model.Cart;
import com.kalababa.model.CartItem;
import com.kalababa.model.Customer;
import com.kalababa.model.Product;
import com.kalababa.model.User;
import com.kalababa.product.model.CameraMaster;
import com.kalababa.product.model.CategoryMaster;
import com.kalababa.product.model.LaptopMaster;
import com.kalababa.product.model.ProductMaster;
import com.kalababa.product.model.TVMaster;
import com.kalababa.service.CartItemService;
import com.kalababa.service.CartService;
import com.kalababa.service.CustomerService;
import com.kalababa.service.ProductService;

@Controller
public class CartItemController {

	private static Logger logger = LoggerFactory.getLogger(CartItemController.class);

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private com.kalababa.product.service.ProductService prodService;

	@RequestMapping("/cart/add")
	public @ResponseBody String addCartItem(@RequestParam(value = "productId") Integer productId,
			@RequestParam(value = "catId") Integer catId, HttpServletRequest req) {
		HttpSession session = req.getSession();

		List cartItems;
		cartItems = (List) session.getAttribute("cartItems");
		if (cartItems == null)
			cartItems = new ArrayList<>();
		CategoryMaster cat = prodService.findCategoryByCategoryId(catId);
		if (cat.getCategoryName().toLowerCase().contains("laptop")
				|| cat.getCategoryName().toLowerCase().contains("pc")) {
			try {
				LaptopMaster lapModel = prodService.findLaptopByProdId(productId);
				cartItems.add(lapModel);
				session.setAttribute("cartItems", cartItems);
				logger.info("Laptop Successfully added to cart");
			} catch (Exception e) {
				logger.error("Unable to find Product by id=" + productId, e);
			}
		} else if (cat.getCategoryName().toLowerCase().contains("tv")
				|| cat.getCategoryName().toLowerCase().contains("television")) {
			try {
				TVMaster tvModel = prodService.findTVByProdId(productId);
				cartItems.add(tvModel);
				session.setAttribute("cartItems", cartItems);
				logger.info("TV Successfully retrieved for Id:" + productId);

			} catch (Exception e) {
				logger.error("Unable to find Product by id=" + productId, e);
			}
		} else if (cat.getCategoryName().toLowerCase().contains("cctv")) {
			try {
				CameraMaster camModel = prodService.findCamByProdId(productId);
				cartItems.add(camModel);
				session.setAttribute("cartItems", cartItems);
				logger.info("Camera Successfully retrieved for Id:" + productId);
			} catch (Exception e) {
				logger.error("Unable to find Product by id=" + productId, e);
			}
		} else {
			try {
				ProductMaster prodModel = prodService.findByProdId(productId);
				CameraMaster camModel = prodService.findCamByProdId(productId);
				cartItems.add(camModel);
				logger.info("Product Successfully retrieved for Id:" + productId);
			} catch (Exception e) {
				logger.error("Unable to find Product by id=" + productId, e);
			}
		}
		return "added to cart";
		/*User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		Customer customer = customerService.getCustomerByemailId(emailId);
		System.out.println("Customer : " + customer.getUsers().getEmailId());
		Cart cart = customer.getCart();
		System.out.println(cart);
		List<CartItem> cartItems = cart.getCartItem();
		Product product = productService.getProductById(productId);
		for (int i = 0; i < cartItems.size(); i++) {
			CartItem cartItem = cartItems.get(i);
			if (product.getProdId().equals(cartItem.getProduct().getProdId())) {
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				//cartItem.setPrice(cartItem.getQuality() * cartItem.getProduct().getProductPrice());
				cartItemService.addCartItem(cartItem);
				return;
			}
		}
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(1);
		cartItem.setProduct(product);
		//cartItem.setPrice(product.getProductPrice() * 1);
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
		}*/
	}

	@RequestMapping("/cart/removeCartItem")
	public @ResponseBody String removeCartItem(@RequestParam(value = "indexId") Integer index, HttpServletRequest req) {
		HttpSession session = req.getSession();

		List cartItems = (List) session.getAttribute("cartItems");
		cartItems.remove(cartItems.get(index - 1));
		session.setAttribute("cartItems", cartItems);
		// cartItemService.removeCartItem(cartItemId);
		return "removed from cart";
	}

	@RequestMapping("/cart/removeAllItems")
	public @ResponseBody String removeAllCartItems(HttpServletRequest req) {
		HttpSession session = req.getSession();

		session.removeAttribute("cartItems");
		return "All Cart Items Removed";
		// Cart cart = cartService.getCartByCartId(cartId);
		// cartItemService.removeAllCartItems(cart);
	}

	@RequestMapping("/cart/view")
	public String viewCart() {
		return "viewCart";
	}

	@RequestMapping("/cart/checkout")
	public String checkout() {
		
		return "checkout";
	}

}
