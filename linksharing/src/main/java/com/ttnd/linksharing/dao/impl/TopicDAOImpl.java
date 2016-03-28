package com.ttnd.linksharing.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ttnd.linksharing.dao.TopicDAO;
import com.ttnd.linksharing.entities.Topic;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public class TopicDAOImpl extends HibernateDaoSupport implements TopicDAO {

	private static final Logger logger = LoggerFactory.getLogger(TopicDAOImpl.class);

	@Override
	public int saveTopic(Topic topic) {
		logger.trace("Inside saveTopic method");
		return (Integer) getHibernateTemplate().save(topic);
	}

}
