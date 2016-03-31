package com.ttnd.linksharing.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ttnd.linksharing.dao.TopicDAO;
import com.ttnd.linksharing.entities.Topic;
import com.ttnd.linksharing.utils.enums.Visibility;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getTopics() {
		logger.trace("Inside getTopics method");
		DetachedCriteria criteria = DetachedCriteria.forClass(Topic.class);
		List<Topic> topics = (List<Topic>) getHibernateTemplate().findByCriteria(criteria);
		return topics;
	}

	@Override
	public Topic getTopic(String name, String username) {
		logger.trace("Inside getTopic by name method");
		DetachedCriteria criteria = DetachedCriteria.forClass(Topic.class);
		criteria.add(Restrictions.eq("name", name)).createCriteria("createdBy").add(Restrictions.eq("username", username));
		List<?> list = getHibernateTemplate().findByCriteria(criteria);
		if (! list.isEmpty()) {
			Topic topic = (Topic) list.get(0);
			return topic;
		}
		return null;
	}

	@Override
	public Topic getTopic(Integer topicId) {
		logger.trace("Inside getTopic by id method");
		DetachedCriteria criteria = DetachedCriteria.forClass(Topic.class);
		criteria.add(Restrictions.eq("topicId", topicId));
		List<?> list = getHibernateTemplate().findByCriteria(criteria);
		if (! list.isEmpty()) {
			Topic topic = (Topic) list.get(0);
			return topic;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getPublicTopics() {
		logger.trace("Inside getPublicTopics method");
		DetachedCriteria criteria = DetachedCriteria.forClass(Topic.class);
		criteria.add(Restrictions.eq("visibility", Visibility.PUBLIC));
		List<Topic> topics = (List<Topic>) getHibernateTemplate().findByCriteria(criteria);
		return topics;
	}

}
