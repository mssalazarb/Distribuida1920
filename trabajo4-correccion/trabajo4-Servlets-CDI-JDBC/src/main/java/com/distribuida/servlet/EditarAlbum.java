package com.distribuida.servlet;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.conexion.Persistencia;
import com.distribuida.dto.Album;
import com.distribuida.producer.PersistenceProducer;
import com.distribuida.producer.ProducerType;

@WebServlet(name="editarAlbum", urlPatterns = {"/ealbum"})
public class EditarAlbum extends HttpServlet{
	
	private static final long serialVersionUID = 2638127270022516617L;
	
	@Inject
	@PersistenceProducer(ProducerType.ALBUM)
	private Persistencia serviceAlbum;
	
	/**
	 * METODO QUE EDITA UN album
	 * */
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
					"	<form action=\"ealbum\" method = \"post\">\r\n" + 
					"		<div>\r\n" + 
					"			Id: <input type=\"number\" name=\"id\" value=\"" + album.getId() + "\"/>\r\n" + 
					"		</div>\r\n" + 
					"		<br/>\r\n" + 
					"		<div>\r\n" + 
					"         	Singer Id: <input type = \"text\" name = \"singer_id\" value=\"" + album.getSinger_id() + "\"/>\r\n" + 
					"        </div>\r\n" + 
					"        <br/>\r\n" + 
					"        <div>\r\n" + 
					"         	Title: <input type = \"text\" name = \"title\" value=\"" + album.getTitle() + "\"/>\r\n" + 
					"        </div>\r\n" + 
					"        <br/>\r\n" + 
					"        <div>\r\n" + 
					"        	Release Date: <input type = \"date\" name = \"release_date\" value=\"" + album.getRelease_date() + "\"/>\r\n" + 
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

}
