package com.ttnd.linksharing.dto;

import java.io.Serializable;

import com.ttnd.linksharing.utils.enums.Visibility;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public class TopicDTO implements Serializable {

	private static final long serialVersionUID = -2867563381104306330L;
	private Integer topicId;
	private String topicName;
	private UserDTO createdBy;
	private Visibility visibility;

	public TopicDTO() {
		super();
	}

	public TopicDTO(String topicName, UserDTO createdBy, Visibility visibility) {
		super();
		this.topicName = topicName;
		this.createdBy = createdBy;
		this.visibility = visibility;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public UserDTO getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDTO createdBy) {
		this.createdBy = createdBy;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

}
