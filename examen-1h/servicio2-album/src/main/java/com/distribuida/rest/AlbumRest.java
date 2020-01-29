package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Album;

import com.distribuida.servicio.AlbumService;

@Path("/albums")
@ApplicationScoped
public class AlbumRest {
	
	@Inject private AlbumService albumService;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Album> listarTodos(){
		return albumService.listarTodos();
	}
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Album listarPorId(@PathParam(value = "id") Integer id) {
		return albumService.buscarPorId(id);
	}
}
