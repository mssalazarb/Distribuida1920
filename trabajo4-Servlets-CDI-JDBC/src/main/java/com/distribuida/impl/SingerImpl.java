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

	private ConexionDB conexionDB;
	
	@Override
	public void crear(Object object) {
		System.out.println("LLEGA A CREAR SINGER");
		conexionDB = new ConexionDB();
		
		Connection conexion = conexionDB.getConexion();
		
		Singer singer = (Singer) object;
		String query = "INSERT INTO singer (id, birth_date, first_name, last_name) " 
						+ "VALUES(" + singer.getId() + ",'" + singer.getBirth_date() 
						+"','" + singer.getLast_name() + "','"+ singer.getFirst_name() +"');";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.executeQuery();
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(Object object) {
		System.out.println("LLEGA A EDITAR SINGER");
		conexionDB = new ConexionDB();
		
		Connection conexion = conexionDB.getConexion();

		Singer singer = (Singer) object;
		String query = "UPDATE singer SET birth_date='" + singer.getBirth_date() + "', " 
						+ "first_name='" + singer.getFirst_name() +"', " + "last_name='"
						+ singer.getLast_name() + "' WHERE id= " + singer.getId() + ";";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.executeQuery();
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(Integer id) {
		System.out.println("LLEGA A ELIMINAR SINGER");
		conexionDB = new ConexionDB();
		
		Connection conexion = conexionDB.getConexion();

		String query = "DELETE FROM singer WHERE id=" + id + ";";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.executeQuery();
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Singer> listar() {
		System.out.println("LLEGA A LISTAR SINGER");
		conexionDB = new ConexionDB();
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
		System.out.println("LLEGA A LISTAR UN SINGER");
		Singer singer = new Singer();
		conexionDB = new ConexionDB();
		Connection conexion = conexionDB.getConexion();
		String query = "SELECT * FROM singer WHERE id=" + id +";";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
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
