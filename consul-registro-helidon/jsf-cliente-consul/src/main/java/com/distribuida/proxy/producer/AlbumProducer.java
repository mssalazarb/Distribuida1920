package com.distribuida.proxy.producer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxy.AlbumProxy;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Service;

@ApplicationScoped
public class AlbumProducer {

	public static final String NAME_ALBUM = "Album-Service";
	
	@Produces
	public AlbumProxy servicioAlbum( ) {
		ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
		String urlAlbum = consultarServicio(NAME_ALBUM);
		ResteasyWebTarget target = client.target(urlAlbum);
		return target.proxy(AlbumProxy.class);
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
				url = String.format( "http://%s:%d/albums", s.getAddress(),
						s.getPort() );
			}
		}
		return url;
	}
}
