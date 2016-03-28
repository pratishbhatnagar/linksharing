package com.ttnd.linksharing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

@Entity
@Table(name = "document_resource")
@PrimaryKeyJoinColumn(name = "resource_id")
public class DocumentResource extends Resource {

	private static final long serialVersionUID = 106784749222615526L;
	private String filePath;

	public DocumentResource() {
		super();
	}

	public DocumentResource(String description, User createdBy, Topic topic, Date dateCreated, Date lastUpdated,
			String filePath) {
		super(description, createdBy, topic, dateCreated, lastUpdated);
		this.filePath = filePath;
	}

	@Column(name = "file_path")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "DocumentResource [filePath=" + filePath + "]";
	}

}
