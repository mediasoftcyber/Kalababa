package com.kalababa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kalababa.model.Queries;

@Repository
public interface QueriesRepository extends JpaRepository<Queries, Serializable> {

	
}
