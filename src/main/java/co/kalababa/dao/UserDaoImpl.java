package co.kalababa.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kalababa.model.User;

@Repository
//@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*public UserDaoImpl() {
		System.out.println(sessionFactory.getClass());
	}*/
	
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		//List<Product> products = session.createQuery("from Product").list();
	 List<User> users=	 session.createCriteria(User.class).list();
	 System.out.println(users);
		session.close();
		return users;
	}

	public void deleteUser(String userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.saveOrUpdate(user);
		//session.flush();
		session.close();// close the session
	}

	
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		System.out.println(user);
		session.close();
	}

	public User getUserById(String userId) {
		// Reading the records from the table
		Session session = sessionFactory.openSession();
		// select * from Product where isbn=i
		// if we call get method,Record doesnot exist it will return null
		// if we call load, if the record doesnt exist it will throw exception
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}
	
}
