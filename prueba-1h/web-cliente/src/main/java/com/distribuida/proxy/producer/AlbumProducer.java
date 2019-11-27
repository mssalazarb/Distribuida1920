package com.distribuida.proxy.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxy.AlbumProxy;

@ApplicationScoped
public class AlbumProducer {

	private static final String URL_ALBUM = "http://127.0.0.1:8080/servidor2-album/albums";
	
	@Produces
	public AlbumProxy servicioAlbum( ) {
		ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = client.target(URL_ALBUM);
		return target.proxy(AlbumProxy.class);
	}
}
