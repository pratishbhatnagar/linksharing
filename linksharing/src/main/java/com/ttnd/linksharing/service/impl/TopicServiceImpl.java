package com.ttnd.linksharing.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ttnd.linksharing.dao.TopicDAO;
import com.ttnd.linksharing.dto.TopicDTO;
import com.ttnd.linksharing.entities.Topic;
import com.ttnd.linksharing.service.TopicService;
import com.ttnd.linksharing.service.UserService;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public class TopicServiceImpl implements TopicService {

	private static final Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);
	TopicDAO topicDAO;
	UserService userService;

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public int saveTopic(TopicDTO topicDTO) {
		logger.trace("Inside saveTopic method");
		int id = 0;
		if (topicDTO != null) {
			Topic topic = new Topic(topicDTO.getTopicName(), userService.getUser(topicDTO.getCreatedBy()), new Date(),
					new Date(), topicDTO.getVisibility());
			logger.info("Topic created : " + topic);
			id = topicDAO.saveTopic(topic);
		}
		return id;
	}

}
