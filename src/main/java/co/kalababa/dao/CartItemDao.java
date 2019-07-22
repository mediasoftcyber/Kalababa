package co.kalababa.dao;

import com.kalababa.model.Cart;
import com.kalababa.model.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);
	void removeCartItem(String CartItemId);
	void removeAllCartItems(Cart cart);

}
