package com.test.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDto  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String description;
	private Date timeStamp;
	private Integer likes;
	
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

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes= likes;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
