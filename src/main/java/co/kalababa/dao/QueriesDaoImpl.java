package co.kalababa.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kalababa.model.Queries;

@Repository
@Transactional
public class QueriesDaoImpl implements QueriesDao  {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addQuery(Queries queries) {
		Session session = sessionFactory.openSession();
		session.save(queries);
		session.close();
	}

}
