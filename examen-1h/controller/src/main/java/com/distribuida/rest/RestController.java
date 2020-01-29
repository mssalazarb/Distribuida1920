package com.distribuida.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.distribuida.controller.Controlador;

@Path("/")
public class RestController {
	
	@Context
	private UriInfo context;
	
	private Controlador controller = new Controlador();
	
	public RestController() {
		
	}

	@GET
	@Path("/singers")
	@Produces(MediaType.APPLICATION_JSON)
	public String listarSingers() {
		return controller.listarSingers();
	}
	
	@GET
	@Path("/singers/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarSinger(@PathParam(value = "id") Integer id) {
		return controller.buscarSinger(id);
	}

	@GET
	@Path("/albums")
	@Produces(MediaType.APPLICATION_JSON)
	public String listarAlbums() {
		return controller.listarAlbums();
	}
	
	@GET
	@Path("/albums/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarAlbum(@PathParam(value = "id") Integer id) {
		return controller.buscarAlbum(id);
	}
	
	@GET
	@Path("/instruments")
	@Produces(MediaType.APPLICATION_JSON)
	public String listarInstruments() {
		return controller.listarInstruments();
	}
	
	@GET
	@Path("/instruments/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarInstrument(@PathParam(value = "id") Integer id) {
		return controller.buscarInstrument(id);
	}
}
