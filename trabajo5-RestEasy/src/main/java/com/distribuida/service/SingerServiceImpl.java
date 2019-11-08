package com.distribuida.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.distribuida.conexion.DataSourceService;
import com.distribuida.dto.Singer;

public class SingerServiceImpl implements SingerService{

	private DataSourceService dss = new DataSourceService();
	private PreparedStatement pst;
	
	@Override
	public Singer crear(Singer singer) {
		String query = "INSERT INTO singer (id, birth_date, first_name, last_name) " 
						+ "VALUES(?,?,?,?);";
		try {
			Connection con = dss.getDataSource().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, singer.getId());
			pst.setDate(2, new java.sql.Date(singer.getBirth_date().getYear(),singer.getBirth_date().getMonth() , singer.getBirth_date().getDay()));
			pst.setString(3, singer.getFirst_name());
			pst.setString(4, singer.getLast_name());
			pst.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singer;
	}

	@Override
	public Singer editar(Singer singer) {
		String query = "UPDATE singer SET birth_date= ?, first_name= ?, last_name= ? "
				+ "WHERE id= ?";
		try {
			Connection con = dss.getDataSource().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setDate(1, new java.sql.Date(singer.getBirth_date().getYear(),singer.getBirth_date().getMonth() , singer.getBirth_date().getDay()));
			pst.setString(2, singer.getFirst_name());
			pst.setString(3, singer.getLast_name());
			pst.setInt(4, singer.getId());
			pst.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singer;
	}

	@Override
	public void eliminar(Integer id) {
		String query = "DELETE FROM singer WHERE id= ?;";
		try {
			Connection con = dss.getDataSource().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Singer> listar() {
		List<Singer> singers = new ArrayList<>();
		String query = "SELECT * FROM singer;";
		try {
			Connection con = dss.getDataSource().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Singer s = new Singer();
				s.setId(rs.getInt(1));
				s.setBirth_date(rs.getDate(2));
				s.setFirst_name(rs.getString(3));
				s.setLast_name(rs.getString(4));
				singers.add(s);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singers;
	}

	@Override
	public Singer buscarPorId(Integer id) {
		Singer singer = new Singer();
		String query = "SELECT * FROM singer WHERE id= ?";
		try {
			Connection con = dss.getDataSource().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				singer.setId(rs.getInt(1));
				singer.setBirth_date(rs.getDate(2));
				singer.setFirst_name(rs.getString(3));
				singer.setLast_name(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singer;
	}
}
