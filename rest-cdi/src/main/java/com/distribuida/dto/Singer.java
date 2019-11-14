package com.distribuida.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Singer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private Integer id;
	@Getter @Setter private String first_name;
	@Getter @Setter private String last_name;
	@Getter @Setter private Date birth_date;

}
