package com.distribuida.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;
import com.distribuida.dto.Singer;

import com.distribuida.service.SingerService;

@Path("/singers")
@ApplicationScoped
public class SingerRest {
	
	@Inject private SingerService singerService;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Singer> listar(){
		return singerService.listar();
	}

}
