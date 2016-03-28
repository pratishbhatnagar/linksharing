package com.ttnd.linksharing.service;

import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.entities.User;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public interface UserService {

	int saveUser(UserDTO userDTO);
	UserDTO getUserDTO(UserDTO userDTO);
	User getUser(UserDTO userDTO);
	
}
