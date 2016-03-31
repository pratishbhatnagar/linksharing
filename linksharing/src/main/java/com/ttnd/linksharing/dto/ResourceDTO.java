package com.ttnd.linksharing.dto;

import java.io.Serializable;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public class ResourceDTO implements Serializable {

	private static final long serialVersionUID = -2454055498473858850L;
	private Integer topicId;
	private String description;
	private UserDTO createdBy;
	private TopicDTO topicDTO;
	private String url;
	private String path;

	public ResourceDTO() {
		super();
	}

	public ResourceDTO(Integer topicId, String description, UserDTO createdBy, String url, String path) {
		super();
		this.topicId = topicId;
		this.description = description;
		this.createdBy = createdBy;
		this.url = url;
		this.path = path;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDTO getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDTO createdBy) {
		this.createdBy = createdBy;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TopicDTO getTopicDTO() {
		return topicDTO;
	}

	public void setTopicDTO(TopicDTO topicDTO) {
		this.topicDTO = topicDTO;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
