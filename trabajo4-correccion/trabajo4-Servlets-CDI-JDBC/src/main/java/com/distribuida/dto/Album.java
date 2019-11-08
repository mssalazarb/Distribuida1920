package com.distribuida.dto;

import java.util.Date;

public class Album {

	private Integer id;
	private Integer singer_id;
	private String title;
	private Date release_date;
	
	public Album() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSinger_id() {
		return singer_id;
	}

	public void setSinger_id(Integer singer_id) {
		this.singer_id = singer_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	
	
}
