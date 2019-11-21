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

import com.distribuida.dto.Album;
import com.distribuida.service.AlbumService;

@Path("/albums")
@ApplicationScoped
public class AlbumRest {

	@Inject private AlbumService albumService;
	
	@POST
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Album guardar(Album album){
		return albumService.guardar(album);
	}
	
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
	
	@DELETE
	@Path("/{id}")
	public void eliminar(@PathParam(value = "id") Integer id) {
		albumService.eliminar(id);
	}
	
	@PUT
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Album editar(Album album){
		return albumService.editar(album);
	}
}
