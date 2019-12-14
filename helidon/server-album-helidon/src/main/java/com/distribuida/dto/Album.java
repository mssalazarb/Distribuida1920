package com.distribuida.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Access(value = AccessType.FIELD)
@Entity
@Table(name = "album")
public class Album implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "album_id")
	private Integer id;
	
	@Column(name = "singer_id")
	private Integer singerId;
	
	@Column(name = "title")
	private String title;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	private Date releaseDate;
	
	public Album() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSingerId() {
		return singerId;
	}

	public void setSingerId(Integer singerId) {
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
