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
public class ResourceUser implements Serializable {

	private static final long serialVersionUID = 7189456990154884270L;
	private Resource resource;
	private User user;

	public ResourceUser() {
		super();
	}

	public ResourceUser(Resource resource, User user) {
		super();
		this.resource = resource;
		this.user = user;
	}

	@ManyToOne
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
