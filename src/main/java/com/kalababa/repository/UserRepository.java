package com.kalababa.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kalababa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

	@Query(name = "from User where emailId=:email")
	public Optional<User> findByEmailId(String email);

	
}
