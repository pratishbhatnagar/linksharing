package com.ttnd.linksharing.dao;

import java.util.List;

import com.ttnd.linksharing.entities.Topic;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public interface TopicDAO {

	int saveTopic(Topic topic);
	Topic getTopic(Integer topicId);
	Topic getTopic(String name, String username);
	List<Topic> getTopics();
	List<Topic> getPublicTopics();

}
