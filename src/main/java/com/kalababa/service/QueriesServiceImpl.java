package com.kalababa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalababa.model.Queries;

import co.kalababa.dao.QueriesDao;

@Service
public class QueriesServiceImpl implements QueriesService {

	//@Autowired
	private QueriesDao queryDao;

	public void addQuery(Queries queries) {

		queryDao.addQuery(queries);
	}

}
