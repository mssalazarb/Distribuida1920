package com.distribuida.impl;

import java.sql.Connection;
import java.sql.Date;
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

	private ConexionDB conexionDB = new ConexionDB();
	private PreparedStatement pst;
	
	@Override
	public void crear(Object object) {
		Album album = (Album) object;
		Connection  conexion= conexionDB.getConexion();
		String query = "INSERT INTO album (id, singer_id, title, release_date) " 
						+ "VALUES(?,?,?,?);";
		try {
			pst = conexion.prepareStatement(query);
			pst.setInt(1, album.getId());
			pst.setInt(2, album.getSinger_id());
			pst.setString(3, album.getTitle());
			pst.setDate(4,  new java.sql.Date(album.getRelease_date().getYear(),album.getRelease_date().getMonth() , album.getRelease_date().getDay()));
			pst.executeQuery();
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(Object object) {
		Album album = (Album) object;
		Connection  conexion= conexionDB.getConexion();
		String query = "UPDATE album SET singer_id= ?, release_date= ?, title=? "
						+ "WHERE id= ?";
		try {
			pst = conexion.prepareStatement(query);
			pst.setInt(1, album.getSinger_id());
			pst.setDate(2, new java.sql.Date(album.getRelease_date().getYear(),album.getRelease_date().getMonth() , album.getRelease_date().getDay()));
			pst.setString(3, album.getTitle());
			pst.setInt(4, album.getId());
			pst.executeQuery();
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(Integer id) {
		String query = "DELETE FROM album WHERE id=?;";
		Connection  conexion= conexionDB.getConexion();
		try {
			pst = conexion.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeQuery();
			conexionDB.cerrarConexion(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> listar() {
		List<Album> albums = new ArrayList<>();
		Connection  conexion= conexionDB.getConexion();
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
		Album album = new Album();
		Connection  conexion= conexionDB.getConexion();
		String query = "SELECT * FROM album WHERE id = ?";
		try {
			pst = conexion.prepareStatement(query);
			pst.setInt(1, id);
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
