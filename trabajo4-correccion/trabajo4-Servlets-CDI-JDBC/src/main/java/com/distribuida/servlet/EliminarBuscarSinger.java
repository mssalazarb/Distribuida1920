package com.distribuida.servlet;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.conexion.Persistencia;
import com.distribuida.dto.Singer;
import com.distribuida.producer.PersistenceProducer;
import com.distribuida.producer.ProducerType;

@WebServlet(name="eliminarBuscarSinger", urlPatterns = {"/ebsinger"})
public class EliminarBuscarSinger extends HttpServlet{

	private static final long serialVersionUID = 2638127270022516617L;
	
	@Inject
	@PersistenceProducer(ProducerType.SINGER)
	private Persistencia serviceSinger;
	
	/**
	 * METODO QUE BUSCA UN SINGER POR SU id
	 * */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Singer singer = new Singer();
		Integer id = Integer.parseInt(request.getParameter("id"));
		singer = (Singer) serviceSinger.buscarPorId(id);
		try {
			PrintWriter out = response.getWriter();
			out.println(singer.getId() + " || " + singer.getFirst_name() + " || " 
						+ singer.getLast_name() + " || " + singer.getBirth_date());
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * METODO QUE ELIMINA UN SINGER POR SU id
	 * */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
		Integer id = Integer.parseInt(request.getParameter("id"));
		serviceSinger.eliminar(id);
		PrintWriter out = response.getWriter();
		out.println("Eliminado correctamente");
		out.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
