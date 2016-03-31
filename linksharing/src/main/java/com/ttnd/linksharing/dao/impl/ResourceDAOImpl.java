package com.ttnd.linksharing.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ttnd.linksharing.dao.ResourceDAO;
import com.ttnd.linksharing.entities.Resource;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public class ResourceDAOImpl extends HibernateDaoSupport implements ResourceDAO {

	private static final Logger logger = LoggerFactory.getLogger(ResourceDAOImpl.class);
	
	@Override
	public int saveResource(Resource resource) {
		logger.trace("Inside saveLinkResourceMethod");
		return (Integer) getHibernateTemplate().save(resource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getResources() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Resource.class).addOrder(Order.desc("resourceId"));
		List<Resource> list = (List<Resource>) getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	@Override
	public Resource getResource(Integer id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Resource.class);
		criteria.add(Restrictions.eq("resourceId", id));
		List<?> list = getHibernateTemplate().findByCriteria(criteria);
		if (! list.isEmpty()) {
			return (Resource) list.get(0);
		}
		return null;
	}

}
