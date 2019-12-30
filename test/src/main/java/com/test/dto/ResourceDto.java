package com.test.dto;

import java.io.Serializable;
import java.util.Date;

public class ResourceDto  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String url;
	private String state;
	private String likes;
	private String type;
	private Date timeStamp;
	
	public ResourceDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

}
