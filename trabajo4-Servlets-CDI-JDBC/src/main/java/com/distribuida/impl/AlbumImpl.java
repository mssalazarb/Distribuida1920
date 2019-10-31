package com.distribuida.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.distribuida.conexion.ConexionDB;
import com.distribuida.conexion.Persistencia;
import com.distribuida.dto.Album;

@ApplicationScoped
public class AlbumImpl implements Persistencia{

	private ConexionDB conexionDB;
	
	@Override
	public void crear(Object object) {
		System.out.println("LLEGA A CREAR ALBUM");
		conexionDB = new ConexionDB();
		
		Connection conexion = conexionDB.getConexion();
		
		Album album = (Album) object;
		String query = "INSERT INTO album (id, singer_id, title, release_date) " 
						+ "VALUES(" + album.getId() + ",'" + album.getSinger_id()
						+"','" + album.getTitle() + "','"+ album.getRelease_date() +"');";
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
		System.out.println("LLEGA A EDITAR ALBUM");
		conexionDB = new ConexionDB();
		
		Connection conexion = conexionDB.getConexion();

		Album album = (Album) object;
		String query = "UPDATE album SET singer_id=" + album.getSinger_id() + ", " 
						+ "release_date='" + album.getRelease_date() +"', " + "title='"
						+ album.getTitle() + "' WHERE id= " + album.getId() + ";";
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
		System.out.println("LLEGA A ELIMINAR ALBUM");
		conexionDB = new ConexionDB();
		
		Connection conexion = conexionDB.getConexion();

		String query = "DELETE FROM album WHERE id=" + id + ";";
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
	public List<Album> listar() {
		System.out.println("LLEGA A LISTAR ALBUM");
		conexionDB = new ConexionDB();
		List<Album> albums = new ArrayList<>();
		Connection conexion = conexionDB.getConexion();

		String query = "SELECT * FROM album;";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Album a = new Album();
				a.setId(rs.getInt(1));
				a.setSinger_id(rs.getInt(2));
				a.setRelease_date(rs.getDate(3));
				a.setTitle(rs.getString(4));
				albums.add(a);
			}
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albums;
	}

	@Override
	public Object buscarPorId(Integer id) {
		System.out.println("LLEGA A LISTAR UN ALBUM");
		Album album = new Album();
		conexionDB = new ConexionDB();
		Connection conexion = conexionDB.getConexion();
		String query = "SELECT * FROM album WHERE id=" + id +";";
		try {
			PreparedStatement pst = conexion.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				album.setId(rs.getInt(1));
				album.setSinger_id(rs.getInt(2));
				album.setRelease_date(rs.getDate(3));
				album.setTitle(rs.getString(4));
			}
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}

}
