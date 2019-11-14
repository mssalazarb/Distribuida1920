package com.distribuida.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.dto.Singer;

public class SingerServiceImpl implements SingerService{

	@Inject private DataSource dataSource;
	
	@Override
	public List<Singer> listar() {
		String sql = "SELECT * FROM singer";
		Connection con = null;
		
		List<Singer> res = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			res = rs.ge
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
