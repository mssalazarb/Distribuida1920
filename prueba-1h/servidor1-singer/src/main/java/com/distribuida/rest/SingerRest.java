package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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

@ApplicationScoped
@Path("/singers")
public class SingerRest {

	@Inject private SingerService singerService;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Singer listar(@PathParam(value = "id") Integer id) {
		Singer singer = singerService.buscarPorId(id);
		return singer;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Singer> listarTodos() {
		List<Singer> singers = singerService.listar();
		return singers;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Singer crear(Singer singer) {
		singer = singerService.crear(singer);	
		return singer;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Singer editar(Singer singer) {
		singer = singerService.editar(singer);
		return singer;
	}
	
	@DELETE
	@Path("/{id}")
	public void eliminar(@PathParam(value = "id") Integer id) {
		singerService.eliminar(id);
	}
}
