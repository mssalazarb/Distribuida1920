package com.distribuida.servlet;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.conexion.Persistencia;
import com.distribuida.dto.Album;
import com.distribuida.producer.PersistenceProducer;
import com.distribuida.producer.ProducerType;

@WebServlet(name="eliminarBuscarAlbum", urlPatterns = {"/ebalbum"})
public class EliminarBuscarAlbum extends HttpServlet{
	
	private static final long serialVersionUID = 2638127270022516617L;
	
	@Inject
	@PersistenceProducer(ProducerType.ALBUM)
	private Persistencia serviceAlbum;

	/**
	 * METODO QUE ELIMINA UN album POR SU id
	 * */
	
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
	}
	
	/**
	 * METODO QUE BUSCA UN album POR SU id
	 * */
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
}
