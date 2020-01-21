package com.kalababa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kalababa.model.Authorities;
import com.kalababa.model.Cart;
import com.kalababa.model.Customer;
import com.kalababa.model.User;
import com.kalababa.repository.AuthoritiesRepository;
import com.kalababa.repository.CustomerRepository;
import com.kalababa.repository.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private UserRepository usersRepo;
	
	@Autowired
	private AuthoritiesRepository authRepo;
	

	// The database transaction happens inside the scope of a persistence
	// context. The persistence context is in JPA the EntityManager ,
	// implemented internally using an Hibernate Session (when using Hibernate
	// as the persistence provider).

	@Transactional(propagation = Propagation.REQUIRED)
	public void addCustomer(Customer customer) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		Cart cart = new Cart();
		customer.getUsers().setPassword(encoder.encode(customer.getUsers().getPassword()));
		customer.getUsers().setEnabled(true);
		customer.setCart(cart);
		cart.setCustomer(customer);
		Authorities authorities = new Authorities();
		authorities.setAuthorities("ROLE_USER");
		authorities.setEmailId(customer.getUsers().getEmailId());
		
		custRepo.save(customer);
		authRepo.save(authorities);	
	}

	public List<Customer> getAllCustomers() {

		return custRepo.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Customer getCustomerByemailId(String emailId) {
		User user = usersRepo.findByEmailId(emailId).get();
		return custRepo.findById(user.getUserId()).get();
	}

}
