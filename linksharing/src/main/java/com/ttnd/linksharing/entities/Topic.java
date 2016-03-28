package com.ttnd.linksharing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ttnd.linksharing.utils.enums.Visibility;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

@Entity
@Table(name = "topic")
public class Topic implements Serializable {

	private static final long serialVersionUID = -2652415939386695721L;
	private Integer topicId;
	private String name;
	private User createdBy;
	private Date dateCreated;
	private Date lastUpdated;
	private Visibility visibility;

	public Topic() {
		super();
	}

	public Topic(String name, User createdBy, Date dateCreated, Date lastUpdated, Visibility visibility) {
		super();
		this.name = name;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.visibility = visibility;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "topic_id")
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class, orphanRemoval = true)
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "last_updated")
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name = "visibility")
	@Enumerated(EnumType.STRING)
	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	@Override
	public String toString() {
		return "Topic : " + name;
	}

}
