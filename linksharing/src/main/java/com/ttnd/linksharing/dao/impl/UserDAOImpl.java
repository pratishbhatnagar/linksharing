package com.ttnd.linksharing.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ttnd.linksharing.dao.UserDAO;
import com.ttnd.linksharing.entities.User;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	private static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	public int saveUser(User user) {
		logger.trace("Inside saveUser method");
		int id = 0;
		if (getUser(user.getUsername()) == null) {
			id = (Integer) getHibernateTemplate().save(user);
			logger.info("New user created with username : " + user.getUsername());
		}
		return id;
	}

	private User getUser(String username) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));
		List<?> list = getHibernateTemplate().findByCriteria(criteria);
		User user = null;
		if (!list.isEmpty()) {
			user = (User) list.get(0);
		}
		return user;
	}

	public User getUser(String username, String password) {
		logger.info("Inside getUser method");
		User user = getUser(username);
		if (user != null && !user.getPassword().equals(password)) {
			user = null;
		}
		return user;
	}

}
