package com.distribuida.proxy;

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

public interface SingerProxy {

	@GET
	@Consumes(value = MediaType.APPLICATION_JSON)
	List<Singer> listarTodos();
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	Singer crearSinger(Singer singer);
	
	@PUT
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	Singer editarSinger(Singer singer);
	
	@DELETE
	@Path("/{id}")
	void eliminarSinger(@PathParam(value = "id") Integer id);
}
