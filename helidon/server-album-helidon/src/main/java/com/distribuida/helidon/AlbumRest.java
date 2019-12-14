package com.distribuida.helidon;

import java.util.List;

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
public class AlbumRest {

	@Inject private AlbumService albumService;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Album listar(@PathParam(value = "id") Integer id) {
		Album album = albumService.buscarPorId(id);
		return album;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> listarTodos() {
		List<Album> albums = albumService.listarTodos();
		return albums;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Album crear(Album album) {
		album = albumService.guardar(album);	
		return album;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Album editar(Album album) {
		album = albumService.editar(album);
		return album;
	}
	
	@DELETE
	@Path("/{id}")
	public void eliminar(@PathParam(value = "id") Integer id) {
		albumService.eliminar(id);
	}
}
