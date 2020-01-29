package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Instrument;
import com.distribuida.servicio.InstrumentService;

@Path("/instruments")
@ApplicationScoped
public class InstrumentRest {
	
	@Inject private InstrumentService instrumentService;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Instrument> listarTodos(){
		return instrumentService.listarTodos();
	}
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Instrument listarPorId(@PathParam(value = "id") Integer id) {
		return instrumentService.buscarPorId(id);
	}
}
