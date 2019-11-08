package com.distribuida.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.distribuida.conexion.ConexionDB;
import com.distribuida.conexion.Persistencia;
import com.distribuida.dto.Singer;

@ApplicationScoped
public class SingerImpl implements Persistencia {

	private ConexionDB conexionDB = new ConexionDB();
	private PreparedStatement pst;
	
	@Override
	public void crear(Object object) {
		Singer singer = (Singer) object;
		Connection conexion = conexionDB.getConexion();
		String query = "INSERT INTO singer (id, birth_date, first_name, last_name) " 
						+ "VALUES(?,?,?,?);";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.setInt(1, singer.getId());
			pst.setDate(2, new java.sql.Date(singer.getBirth_date().getYear(),singer.getBirth_date().getMonth() , singer.getBirth_date().getDay()));
			pst.setString(3, singer.getFirst_name());
			pst.setString(4, singer.getLast_name());
			pst.executeQuery();
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(Object object) {
		Singer singer = (Singer) object;
		Connection conexion = conexionDB.getConexion();
		String query = "UPDATE singer SET birth_date= ?, first_name= ?, last_name= ? "
				+ "WHERE id= ?";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.setDate(1, new java.sql.Date(singer.getBirth_date().getYear(),singer.getBirth_date().getMonth() , singer.getBirth_date().getDay()));
			pst.setString(2, singer.getFirst_name());
			pst.setString(3, singer.getLast_name());
			pst.setInt(4, singer.getId());
			pst.executeQuery();
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(Integer id) {
		String query = "DELETE FROM singer WHERE id= ?;";
		Connection conexion = conexionDB.getConexion();
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeQuery();
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Singer> listar() {
		List<Singer> singers = new ArrayList<>();
		Connection conexion = conexionDB.getConexion();
		String query = "SELECT * FROM singer;";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Singer s = new Singer();
				s.setId(rs.getInt(1));
				s.setBirth_date(rs.getDate(2));
				s.setFirst_name(rs.getString(3));
				s.setLast_name(rs.getString(4));
				singers.add(s);
			}
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singers;
	}

	@Override
	public Object buscarPorId(Integer id) {
		Singer singer = new Singer();
		Connection conexion = conexionDB.getConexion();
		String query = "SELECT * FROM singer WHERE id= ?";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				singer.setId(rs.getInt(1));
				singer.setBirth_date(rs.getDate(2));
				singer.setFirst_name(rs.getString(3));
				singer.setLast_name(rs.getString(4));
			}
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singer;
	}

}
