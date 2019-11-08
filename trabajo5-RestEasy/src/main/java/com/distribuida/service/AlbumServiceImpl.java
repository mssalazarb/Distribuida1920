package com.distribuida.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.distribuida.conexion.DataSourceService;
import com.distribuida.dto.Album;

public class AlbumServiceImpl implements AlbumService{
	
	private DataSourceService dss = new DataSourceService();
	private PreparedStatement pst;
	
	@Override
	public Album crear(Album album) {
		String query = "INSERT INTO album (id, singer_id, title, release_date) " 
						+ "VALUES(?,?,?,?);";
		try {
			Connection con = dss.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, album.getId());
			pst.setInt(2, album.getSinger_id());
			pst.setString(3, album.getTitle());
			pst.setDate(4,  new java.sql.Date(album.getRelease_date().getYear(),album.getRelease_date().getMonth() , album.getRelease_date().getDay()));
			pst.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}

	@Override
	public Album editar(Album album) {
		String query = "UPDATE album SET singer_id= ?, release_date= ?, title=? "
						+ "WHERE id= ?";
		try {
			Connection con = dss.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, album.getSinger_id());
			pst.setDate(2, new java.sql.Date(album.getRelease_date().getYear(),album.getRelease_date().getMonth() , album.getRelease_date().getDay()));
			pst.setString(3, album.getTitle());
			pst.setInt(4, album.getId());
			pst.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}

	@Override
	public void eliminar(Integer id) {
		String query = "DELETE FROM album WHERE id=?;";
		try {
			Connection con = dss.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> listar() {
		List<Album> albums = new ArrayList<>();
		String query = "SELECT * FROM album;";
		try {
			Connection con = dss.getDataSource().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Album a = new Album();
				a.setId(rs.getInt(1));
				a.setSinger_id(rs.getInt(2));
				a.setRelease_date(rs.getDate(3));
				a.setTitle(rs.getString(4));
				albums.add(a);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albums;
	}

	@Override
	public Album buscarPorId(Integer id) {
		Album album = new Album();
		String query = "SELECT * FROM album WHERE id = ?";
		try {
			Connection con = dss.getDataSource().getConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				album.setId(rs.getInt(1));
				album.setSinger_id(rs.getInt(2));
				album.setRelease_date(rs.getDate(3));
				album.setTitle(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}
}
