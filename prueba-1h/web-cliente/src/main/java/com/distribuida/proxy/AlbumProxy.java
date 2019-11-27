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

import com.distribuida.dto.Album;

public interface AlbumProxy {

	@GET
	@Consumes(value = MediaType.APPLICATION_XML)
	List<Album> listarTodos();
	
	@POST
	@Consumes(value = MediaType.APPLICATION_XML)
	@Produces(value = MediaType.APPLICATION_XML)
	Album crearAlbum(Album album);
	
	@PUT
	@Consumes(value = MediaType.APPLICATION_XML)
	@Produces(value = MediaType.APPLICATION_XML)
	Album editarAlbum(Album album);
	
	@DELETE
	@Path("/{id}")
	void eliminarAlbum(@PathParam(value = "id") Integer id);
}
