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

@WebServlet(name="crearListarSinger", urlPatterns = {"/clsinger"})
public class CrearListarSinger extends HttpServlet{
	
private static final long serialVersionUID = 2638127270022516617L;
	
	@Inject
	@PersistenceProducer(ProducerType.SINGER)
	private Persistencia serviceSinger;
	
	/**
	 * METODO QUE LISTA TODOS LOS SINGER
	 * */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Singer> singers = new ArrayList<>();
		singers = serviceSinger.listar();
		try {
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<h3>Editar singer</h3>\r\n" +
					"<table><tr>\r\n"+
					"<th> Id </th>\r\n" +
					"<th> First Name </th>\r\n" +
					"<th> Last Name </th>\r\n" +
					"<th> Birth Date </th></tr>\r\n");
			
			
			for(Singer singer : singers) {
				out.println("<tr>\r\n" +
							"<td> " + singer.getId() + "</td> \r\n" +
							"<td> " + singer.getFirst_name() + "</td> \r\n" +
							"<td> " + singer.getLast_name() + "</td> \r\n" +
							"<td> " + singer.getBirth_date() + "</td></tr> \r\n");
			}
			
			out.println("</table></body>\r\n" + 
					"</html>");
			out.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
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

}
