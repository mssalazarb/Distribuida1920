package com.distribuida.rest;

import java.util.Set;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

@ApplicationScoped
@ApplicationPath("/")
public class Servidor1Application extends Application{
	
	@Inject
	@ConfigProperty(name = "server.port", defaultValue = "8080")
	private Integer puerto;
	
	@Inject
	@ConfigProperty(name = "consul.server", defaultValue = "127.0.0.1")
	private String consulHost;
	
	@Inject
	@ConfigProperty(name = "consul.port", defaultValue = "8500")
	private Integer consulPort;
	
	private String id = UUID.randomUUID().toString();
	
	@Override
	public Set<Class<?>> getClasses() {
		return Set.of(HolaMundoRest.class, PingRest.class);
	}
	
	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		System.out.println("Inicializando");
		
		ConsulClient client = new ConsulClient(consulHost, consulPort);
		
		NewService s = new NewService();
		
		s.setName("Hola-Mundo");
		s.setId(id);
		s.setAddress("127.0.0.1");
		s.setPort(puerto);
		
		NewService.Check check = new NewService.Check();
		check.setMethod("GET");
		check.setHttp("http://127.0.0.1:" + puerto + "/ping");
		check.setInterval( "10s" );
		check.setDeregisterCriticalServiceAfter("20s");
		s.setCheck(check);
		
		client.agentServiceRegister(s);
		
	}
	
	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
		System.out.println("Deteniendo");
		ConsulClient client = new ConsulClient();
		client.agentServiceDeregister(id);
	}
	
}
