package com.distribuida.servlet;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.conexion.Persistencia;
import com.distribuida.dto.Album;
import com.distribuida.producer.PersistenceProducer;
import com.distribuida.producer.ProducerType;

@WebServlet(name="albumServlet", urlPatterns = {"/albumCdi"})
public class AlbumServlet extends HttpServlet{
	
	private static final long serialVersionUID = 2638127270022516617L;
	
	@Inject
	@PersistenceProducer(ProducerType.ALBUM)
	private Persistencia serviceAlbum;
	
	/**
	 * NOTA: Solo debe haber un metodo Post y Get en la clase, por lo tanto,
	 * 		se debe descomentar el metodo a utilizar y comentar el metodo que 
	 * 		no se va a utilizar ya que WebServlet solo puede tener un doGet o
	 * 		doPost
	 * */
	
	/**
	 * METODO QUE LISTA TODOS LOS album
	 * */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Album> albums = new ArrayList<>();
		albums = serviceAlbum.listar();
		try {
			PrintWriter out = response.getWriter();
			for(Album album : albums) {
				out.println(album.getId() + " || " + album.getSinger_id() + " || " 
						+ album.getTitle() + " || " + album.getRelease_date());
			}
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * METODO QUE BUSCA UN album POR SU id
	 * */
	/*
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Album album = new Album();
		Integer id = Integer.parseInt(request.getParameter("id"));
		album = (Album) serviceAlbum.buscarPorId(id);
		try {
			PrintWriter out = response.getWriter();
			out.println(album.getId() + " || " + album.getSinger_id() + " || " 
						+ album.getTitle() + " || " + album.getRelease_date());
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * METODO QUE CREA UN album
	 * */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Album album = new Album();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		album.setId(Integer.parseInt(request.getParameter("id")));
		album.setSinger_id(Integer.parseInt(request.getParameter("singer_id")));
		album.setTitle(request.getParameter("title"));
		album.setRelease_date(sdf.parse(request.getParameter("release_date")));

		serviceAlbum.crear(album);
		PrintWriter out = response.getWriter();
		out.println("Creado correctamente");
		out.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * METODO QUE ELIMINA UN album POR SU id
	 * */
	/*
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
		Integer id = Integer.parseInt(request.getParameter("id"));
		serviceAlbum.eliminar(id);
		PrintWriter out = response.getWriter();
		out.println("Eliminado correctamente");
		out.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * METODO QUE EDITA UN album
	 * */
	/*
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Album album = new Album();
		Integer id = Integer.parseInt(request.getParameter("id"));
		album = (Album) serviceAlbum.buscarPorId(id);
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<h3>Editar album</h3>\r\n" + 
					"	<form action=\"albumCdi\" method = \"post\">\r\n" + 
					"		<div>\r\n" + 
					"			Id: <input type=\"number\" name=\"id\" value=\"" + album.getId() + "\"/>\r\n" + 
					"		</div>\r\n" + 
					"		<br/>\r\n" + 
					"		<div>\r\n" + 
					"         	Singer Id: <input type = \"text\" name = \"first_name\" value=\"" + album.getSinger_id() + "\"/>\r\n" + 
					"        </div>\r\n" + 
					"        <br/>\r\n" + 
					"        <div>\r\n" + 
					"         	Title: <input type = \"text\" name = \"last_name\" value=\"" + album.getTitle() + "\"/>\r\n" + 
					"        </div>\r\n" + 
					"        <br/>\r\n" + 
					"        <div>\r\n" + 
					"        	Release Date: <input type = \"date\" name = \"birth_date\" value=\"" + album.getRelease_date() + "\"/>\r\n" + 
					"        </div>\r\n" + 
					"        <br/> \r\n" + 
					"         <input type = \"submit\" value = \"Editar\" />\r\n" + 
					"      </form>\r\n" + 
					"</body>\r\n" + 
					"</html>");

			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Album album = new Album();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			album.setId(Integer.parseInt(request.getParameter("id")));
			album.setSinger_id(Integer.parseInt(request.getParameter("singer_id")));
			album.setTitle(request.getParameter("title"));
			album.setRelease_date(sdf.parse(request.getParameter("release_date")));

			serviceAlbum.editar(album);
			PrintWriter out = response.getWriter();
			out.println("Actualizado correctamente");
			out.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
