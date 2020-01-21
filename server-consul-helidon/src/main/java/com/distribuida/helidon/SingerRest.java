package com.distribuida.helidon;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/microprofile")
public class SingerRest {
	
	//Sirve para sacar una sola propiedad de las configuraciones
	@Inject
	@ConfigProperty(name = "texto")
	private String mensaje;
	
	//Sirve para sacar todas las configuraciones desde el codigo
	@Inject
	private Config config;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarTodos() {
		config.getConfigSources().forEach(s -> {
			System.out.println(s.getName());
		});
		return mensaje + " : " + config.getValue("server.port", String.class);
	}
}
