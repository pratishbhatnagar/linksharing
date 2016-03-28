package com.ttnd.linksharing.dao;

import com.ttnd.linksharing.entities.User;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public interface UserDAO {

	int saveUser(User user);
	User getUser(String username, String password);
	
}
