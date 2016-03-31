package com.ttnd.linksharing.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ttnd.linksharing.dao.TopicDAO;
import com.ttnd.linksharing.dto.TopicDTO;
import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.entities.Topic;
import com.ttnd.linksharing.entities.User;
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
		if (topicDTO != null
				&& topicDAO.getTopic(topicDTO.getTopicName(), topicDTO.getCreatedBy().getUsername()) == null) {
			Topic topic = new Topic(topicDTO.getTopicName(), userService.getUser(topicDTO.getCreatedBy()), new Date(),
					new Date(), topicDTO.getVisibility());
			logger.info("Topic created : " + topic);
			id = topicDAO.saveTopic(topic);
		}
		return id;
	}

	@Override
	public List<TopicDTO> getTopicDTOs() {
		logger.trace("Inside getTopics method");
		List<TopicDTO> topicDTOs = new ArrayList<>();
		List<Topic> topics = topicDAO.getTopics();
		for (Topic topic : topics) {
			/*
			 * BeanUtils.copyProperties(topic, topicDTO);
			 * topicDTOs.add(topicDTO);
			 */
			topicDTOs.add(topicToTopicDTO(topic));
		}
		return topicDTOs;
	}

	@Override
	public Topic getTopic(TopicDTO topicDTO) {
		return topicDAO.getTopic(topicDTO.getTopicName(), topicDTO.getCreatedBy().getUsername());
	}

	@Override
	public Topic getTopic(Integer topicId) {
		return topicDAO.getTopic(topicId);
	}

	@Override
	public List<TopicDTO> getPublicTopicDTOs() {
		List<TopicDTO> publicTopicDTOs = new ArrayList<>();
		List<Topic> topics = topicDAO.getPublicTopics();
		for (Topic topic : topics) {
			publicTopicDTOs.add(topicToTopicDTO(topic));
		}
		return publicTopicDTOs;
	}

	private TopicDTO topicToTopicDTO(Topic topic) {
		User user = topic.getCreatedBy();
		UserDTO userDTO = new UserDTO(user.getEmail(), user.getUsername(), user.getPassword(), user.getFirstName(),
				user.getLastName());
		TopicDTO topicDTO = new TopicDTO(topic.getName(), userDTO, topic.getVisibility());
		topicDTO.setTopicId(topic.getTopicId());
		return topicDTO;
	}

}
