package com.kalababa.service;

import com.kalababa.model.CustomerOrder;

public interface CustomerOrderService {

	void addCustomerOrder(CustomerOrder customerOrder);
	double getCustomerOrderGrandTotal(Integer cartId);
}
