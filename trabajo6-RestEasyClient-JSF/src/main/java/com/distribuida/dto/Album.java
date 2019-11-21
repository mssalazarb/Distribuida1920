package com.distribuida.dto;

import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Singer singerId;

	private String title;
	
	private Date releaseDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Singer getSingerId() {
		return singerId;
	}

	public void setSingerId(Singer singerId) {
		this.singerId = singerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
