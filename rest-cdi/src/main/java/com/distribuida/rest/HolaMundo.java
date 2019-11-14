package com.distribuida.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.service.HolaMundoService;

@Path("/hola")
public class HolaMundo {

	@Inject
	private HolaMundoService servicio;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public String hola( ) {
		return servicio.hola();
	}
}
