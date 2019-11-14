package com.distribuida.service;

import java.sql.Connection;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

@ApplicationScoped
public class HolaMundoServiceImpl implements HolaMundoService{

	@Inject private DataSource dataSource;
	
	@Override
	public String hola() {
		
		try {
			Connection con = dataSource.getConnection();
			
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		return "HOLA MUNDO " + new Date();
	}
}
