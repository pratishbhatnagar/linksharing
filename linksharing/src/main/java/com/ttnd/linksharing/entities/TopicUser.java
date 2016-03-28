package com.ttnd.linksharing.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

@Embeddable
public class TopicUser implements Serializable {

	private static final long serialVersionUID = 1248683656731509675L;
	private Topic topic;
	private User user;

	public TopicUser() {
		super();
	}

	public TopicUser(Topic topic, User user) {
		super();
		this.topic = topic;
		this.user = user;
	}

	@ManyToOne
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
