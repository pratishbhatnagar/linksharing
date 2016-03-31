package com.ttnd.linksharing.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ttnd.linksharing.dao.UserDAO;
import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.entities.User;
import com.ttnd.linksharing.service.UserService;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

@Service
public class UserServiceImpl implements UserService {

	UserDAO userDAO;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public int saveUser(UserDTO userDTO) {
		int id = 0;
		if (userDTO != null) {
			User user = new User(userDTO.getEmail(), userDTO.getUsername(), userDTO.getPassword(),
					userDTO.getFirstName(), userDTO.getLastName(), new Date(), new Date());
			logger.info("User created : " + user);
			
			id = userDAO.saveUser(user);
		}
		return id;
	}

	public UserDTO getUserDTO(UserDTO userDTO) {
		User user = userDAO.getUser(userDTO.getUsername(), userDTO.getPassword());
		userDTO = null;
		if (user != null) {
			userDTO = new UserDTO(user.getEmail(), user.getUsername(), user.getPassword(), user.getFirstName(),
					user.getLastName());
		}
		return userDTO;
	}

	public User getUser(UserDTO userDTO) {
		return userDAO.getUser(userDTO.getUsername(), userDTO.getPassword());
	}

}
