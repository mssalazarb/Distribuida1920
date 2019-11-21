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

@Path("/singers")
@ApplicationScoped
public class SingerRest {
	
	@Inject private SingerService singerService;
	
	@POST
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Singer guardar(Singer singer){
		return singerService.guardar(singer);
	}
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Singer> listarTodos(){
		return singerService.listarTodos();
	}
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Singer listarPorId(@PathParam(value = "id") Integer id) {
		return singerService.buscarPorId(id);
	}
	
	@DELETE
	@Path("/{id}")
	public void eliminar(@PathParam(value = "id") Integer id) {
		singerService.eliminar(id);
	}
	
	@PUT
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Singer editar(Singer singer){
		return singerService.editar(singer);
	}
}
