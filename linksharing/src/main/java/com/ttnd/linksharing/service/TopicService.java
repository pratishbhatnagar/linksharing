package com.ttnd.linksharing.service;

import java.util.List;

import com.ttnd.linksharing.dto.TopicDTO;
import com.ttnd.linksharing.entities.Topic;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public interface TopicService {
	
	int saveTopic(TopicDTO topicDTO);
	List<TopicDTO> getTopicDTOs();
	List<TopicDTO> getPublicTopicDTOs();
	Topic getTopic(Integer topicId);
	Topic getTopic(TopicDTO topicDTO);

}
