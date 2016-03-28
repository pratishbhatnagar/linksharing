package com.ttnd.linksharing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.ttnd.linksharing.utils.enums.Seriousness;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

@Entity
@Table(name = "subscription")
@AssociationOverrides({ @AssociationOverride(name = "topicUser.user", joinColumns = @JoinColumn(name = "user_id") ),
		@AssociationOverride(name = "topicUser.topic", joinColumns = @JoinColumn(name = "topic_id") ) })
public class Subscription implements Serializable {
	
	private static final long serialVersionUID = 6861778661867958629L;
	private Integer subscriptionId;
	private TopicUser topicUser = new TopicUser();
	private Seriousness seriousness;
	private Date dateCreated;

	public Subscription() {
		super();
	}

	public Subscription(TopicUser topicUser, Seriousness seriousness, Date dateCreated) {
		super();
		this.topicUser = topicUser;
		this.seriousness = seriousness;
		this.dateCreated = dateCreated;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subscription_id")
	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	@EmbeddedId
	public TopicUser getTopicUser() {
		return topicUser;
	}

	public void setTopicUser(TopicUser topicUser) {
		this.topicUser = topicUser;
	}

	@Transient
	public Topic getTopic() {
		return topicUser.getTopic();
	}

	public void setTopic(Topic topic) {
		topicUser.setTopic(topic);
	}

	@Transient
	public User getUser() {
		return topicUser.getUser();
	}

	public void setUser(User user) {
		topicUser.setUser(user);
	}

	@Column(name = "seriousness")
	@Enumerated(EnumType.STRING)
	public Seriousness getSeriousness() {
		return seriousness;
	}

	public void setSeriousness(Seriousness seriousness) {
		this.seriousness = seriousness;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_created")
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Subscription : " + topicUser;
	}

}
