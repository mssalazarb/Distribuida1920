package com.distribuida.proxy.producer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxy.SingerProxy;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Service;

@ApplicationScoped
public class SingerProducer {
	
	public static final String NAME_SINGER = "Singer-Service";
	
	@Produces
	public SingerProxy servicioSinger( ) {
		ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
		String urlSinger = consultarServicio(NAME_SINGER);
		ResteasyWebTarget target = client.target(urlSinger);
		return target.proxy(SingerProxy.class);
	}
	
	public String consultarServicio(String servicio) {
		ConsulClient cliente = new ConsulClient("127.0.0.1");
		String url = "";
		Response<Map<String, Service>> ss= cliente.getAgentServices();
		Map<String, Service> servicios = ss.getValue();
		
		List<Service> lista = servicios.values()
				.stream()
				.filter(s -> servicio.equals(s.getService()))
				.collect(Collectors.toList());
		
		if(!lista.isEmpty()) {
			for (Service s:lista) {
				url = String.format( "http://%s:%d/singers", s.getAddress(),
						s.getPort() );
			}
		}
		System.out.println(">>>>>>>>" + url);
		return url;
	}
}
