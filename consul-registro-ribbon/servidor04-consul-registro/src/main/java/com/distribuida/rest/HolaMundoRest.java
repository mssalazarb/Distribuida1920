package com.distribuida.rest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Service;

@Path("servicio")
@ApplicationScoped
public class HolaMundoRest {

//	@Inject
//	@ConfigProperty(name = "texto")
//	private String mensaje;
	
	@Inject
	private Config config;
	
	public static final String NAME_SERVICE = "Hola-Mundo";
	
	@GET
	@Path("/hola")
	@Produces(MediaType.APPLICATION_JSON)
	public String saludo() {
		ConsulClient cliente = new ConsulClient("127.0.0.1");
		String url = "";
		Response<Map<String, Service>> ss= cliente.getAgentServices();
		Map<String, Service> servicios = ss.getValue();
		
		List<Service> lista = servicios.values()
				.stream()
				.filter(s -> NAME_SERVICE.equals(s.getService()))
				.collect(Collectors.toList());
		
		if(!lista.isEmpty()) {
			for (Service s:lista) {
				url = url + String.format("%s:%d", s.getAddress(),
						s.getPort() ) + "\n";
			}
		}
		return url;
	}
	
}
