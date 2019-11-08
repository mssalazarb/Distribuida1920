package com.distribuida.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Singer;

import com.distribuida.service.SingerService;
import com.distribuida.service.SingerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/singers")
public class SingerRest {

	private SingerService singerService = new SingerServiceImpl();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(@PathParam(value = "id") Integer id) {
		Singer singer = singerService.buscarPorId(id);
		String resp = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			resp = mapper.writeValueAsString(singer);
		}catch(Exception e) {
			e.printStackTrace();
			resp = "ERROR AL LISTAR POR ID";
		}
		return resp;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarTodos() {
		List<Singer> singers = singerService.listar();
		String resp = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			for (Singer s : singers) {
				resp = resp + mapper.writeValueAsString(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
			resp = "ERROR AL LISTAR TODOS";
		}
		return resp;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String crear(String singer) {
		String resp = "";
		Singer s = new Singer();
		ObjectMapper mapper = new ObjectMapper();
		try {
			s = mapper.readValue(singer, Singer.class);
			s = singerService.crear(s);
			resp = mapper.writeValueAsString(s);
		}catch(Exception e) {
			e.printStackTrace();
			resp = "ERROR AL CREAR";
		}
		return resp;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editar(String singer) {
		String resp = "";
		Singer s = new Singer();
		ObjectMapper mapper = new ObjectMapper();
		try {
			s = mapper.readValue(singer, Singer.class);
			s = singerService.editar(s);
			resp = mapper.writeValueAsString(s);
		}catch(Exception e) {
			e.printStackTrace();
			resp = "ERROR AL EDITAR";
		}
		return resp;
	}
	
	@DELETE
	@Path("/{id}")
	public void eliminar(@PathParam(value = "id") Integer id) {
		singerService.eliminar(id);
		String resp = "";
	}
}
