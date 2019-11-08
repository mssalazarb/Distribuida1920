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

@WebServlet(name="crearListarAlbum", urlPatterns = {"/clalbum"})
public class CrearListarAlbum extends HttpServlet{
	
	private static final long serialVersionUID = 2638127270022516617L;
	
	@Inject
	@PersistenceProducer(ProducerType.ALBUM)
	private Persistencia serviceAlbum;
	
	
	/**
	 * METODO QUE LISTA TODOS LOS album
	 * */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Album> albums = new ArrayList<>();
		albums = serviceAlbum.listar();
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
					"<table><tr>\r\n"+
					"<th> Id </th>\r\n" +
					"<th> IdSinger </th>\r\n" +
					"<th> Title </th>\r\n" +
					"<th> Release Date </th></tr>\r\n");
			
			
			for(Album album : albums) {
				out.println("<tr>\r\n" +
							"<td> " + album.getId() + "</td> \r\n" +
							"<td> " + album.getSinger_id() + "</td> \r\n" +
							"<td> " + album.getTitle() + "</td> \r\n" +
							"<td> " + album.getRelease_date() + "</td></tr> \r\n");
			}
			
			out.println("</table></body>\r\n" + 
					"</html>");
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
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

}
