package com.test.dto;

import java.util.Date;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "POST")
public class ResourceDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String description;
	private String status;
	private Date timeStamp;
	private Integer likes; // Later it will be List of unique users who like it
	/*
	 * @LazyCollection(LazyCollectionOption.FALSE)
	 * 
	 * @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval =
	 * true) private List<Comment> comments = new ArrayList<>();
	 * 
	 * @LazyCollection(LazyCollectionOption.FALSE)
	 * 
	 * @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval =
	 * true) private List<Resource> resources = new ArrayList<>();
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

}
