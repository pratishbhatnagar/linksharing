package com.ttnd.linksharing.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -118456052350988574L;
	private Integer userId;
	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Byte photo;
	private Boolean admin;
	private Boolean active;
	private Date dateCreated;
	private Date lastUpdated;

	public User() {
		super();
	}

	public User(String email, String username, String password, String firstName, String lastName, Date dateCreated, Date lastUpdated) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "photo")
	public Byte getPhoto() {
		return photo;
	}

	public void setPhoto(Byte photo) {
		this.photo = photo;
	}

	@Column(name = "admin")
	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Column(name = "active")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_created")
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

	@Override
	public String toString() {
		return "User : " + firstName + " " + lastName;
	}

}
