package com.distribuida.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Album implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Getter @Setter private Integer id;
	@Getter @Setter private Integer singer_id;
	@Getter @Setter private String title;
	@Getter @Setter private Date release_Date;
}
