package com.ttnd.linksharing.dao;

import java.util.List;

import com.ttnd.linksharing.entities.Resource;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public interface ResourceDAO {

	int saveResource(Resource resource);
	Resource getResource(Integer id);
	List<Resource> getResources();
	
}
