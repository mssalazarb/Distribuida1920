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
import com.distribuida.dto.Singer;
import com.distribuida.producer.PersistenceProducer;
import com.distribuida.producer.ProducerType;

@WebServlet(name="singerServlet", urlPatterns = {"/singerCdi"})
public class SingerServlet extends HttpServlet{

	private static final long serialVersionUID = 2638127270022516617L;
	
	@Inject
	@PersistenceProducer(ProducerType.SINGER)
	private Persistencia serviceSinger;
	
	/**
	 * NOTA: Solo debe haber un metodo Post y Get en la clase, por lo tanto,
	 * 		se debe descomentar el metodo a utilizar y comentar el metodo que 
	 * 		no se va a utilizar ya que WebServlet solo puede tener un doGet o
	 * 		doPost
	 * */
	
	/**
	 * METODO QUE LISTA TODOS LOS SINGER
	 * */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Singer> singers = new ArrayList<>();
		singers = serviceSinger.listar();
		try {
			PrintWriter out = response.getWriter();
			for(Singer singer : singers) {
				out.println(singer.getId() + " || " + singer.getFirst_name() + " || " 
						+ singer.getLast_name() + " || " + singer.getBirth_date());
			}
			out.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * METODO QUE BUSCA UN SINGER POR SU id
	 * */
	/*
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
	}*/
	
	/**
	 * METODO QUE CREA UN SINGER
	 * */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Singer singer = new Singer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		singer.setId(Integer.parseInt(request.getParameter("id")));
		singer.setFirst_name(request.getParameter("first_name"));
		singer.setLast_name(request.getParameter("last_name"));
		singer.setBirth_date(sdf.parse(request.getParameter("birth_date")));

		serviceSinger.crear(singer);
		PrintWriter out = response.getWriter();
		out.println("Creado correctamente");
		out.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * METODO QUE ELIMINA UN SINGER POR SU id
	 * */
	/*
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
	}*/
	
	/**
	 * METODO QUE EDITA UN SINGER
	 * */
	/*
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Singer singer = new Singer();
		Integer id = Integer.parseInt(request.getParameter("id"));
		singer = (Singer) serviceSinger.buscarPorId(id);
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
					"	<h3>Editar Singer</h3>\r\n" + 
					"	<form action=\"singerCdi\" method = \"post\">\r\n" + 
					"		<div>\r\n" + 
					"			Id: <input type=\"number\" name=\"id\" value=\"" + singer.getId() + "\"/>\r\n" + 
					"		</div>\r\n" + 
					"		<br/>\r\n" + 
					"		<div>\r\n" + 
					"         	First Name: <input type = \"text\" name = \"first_name\" value=\"" + singer.getFirst_name() + "\"/>\r\n" + 
					"        </div>\r\n" + 
					"        <br/>\r\n" + 
					"        <div>\r\n" + 
					"         	Last Name: <input type = \"text\" name = \"last_name\" value=\"" + singer.getLast_name() + "\"/>\r\n" + 
					"        </div>\r\n" + 
					"        <br/>\r\n" + 
					"        <div>\r\n" + 
					"        	Birth Date: <input type = \"date\" name = \"birth_date\" value=\"" + singer.getBirth_date() + "\"/>\r\n" + 
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
		Singer singer = new Singer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			singer.setId(Integer.parseInt(request.getParameter("id")));
			singer.setFirst_name(request.getParameter("first_name"));
			singer.setLast_name(request.getParameter("last_name"));
			singer.setBirth_date(sdf.parse(request.getParameter("birth_date")));

			serviceSinger.editar(singer);
			PrintWriter out = response.getWriter();
			out.println("Actualizado correctamente");
			out.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}*/
}
