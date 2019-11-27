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

@ApplicationScoped
@Path("/albums")
public class AlbumRest {

	@Inject private AlbumService albumService;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Album listar(@PathParam(value = "id") Integer id) {
		Album singer = albumService.buscarPorId(id);
		return singer;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Album> listarTodos() {
		List<Album> singers = albumService.listar();
		return singers;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Album crear(Album singer) {
		singer = albumService.crear(singer);	
		return singer;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Album editar(Album singer) {
		singer = albumService.editar(singer);
		return singer;
	}
	
	@DELETE
	@Path("/{id}")
	public void eliminar(@PathParam(value = "id") Integer id) {
		albumService.eliminar(id);
	}
}
