package com.distribuida.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;

@Path("servicio")
@ApplicationScoped
public class HolaMundoRest {

//	@Inject
//	@ConfigProperty(name = "texto")
//	private String mensaje;
	
	@Inject
	private Config config;
	
	@GET
	@Path("/hola")
	@Produces(MediaType.APPLICATION_JSON)
	public String saludo() {
		
		//config.getValue("texto", String.class);
		
		config.getConfigSources().forEach(s->{
			System.out.println( s.getName());
		});;
		
		//return mensaje;
		
		return "Hola Mundo";
	}
	
}
