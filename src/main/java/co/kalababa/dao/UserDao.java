package co.kalababa.dao;

import java.util.List;

import com.kalababa.model.User;

public interface UserDao {

	List<User> getAllUsers();

	void deleteUser(String userId);
	
	void addUser(User user);
	
	User getUserById(String userId);
}
