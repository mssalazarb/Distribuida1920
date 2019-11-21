package com.distribuida.proxy;

import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.dto.Album;

public class AlbumProxyImpl {

private static final String URL_ALBUM = "http://127.0.0.1:8080/trabajo6-RestEasy-CDI-JPA/albums";
	
	public List<Album> listarTodos(){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_ALBUM));
		AlbumProxy proxy = target.proxy(AlbumProxy.class);
		return proxy.listarTodos();
	}
	
	public Album crearAlbum(Album album) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_ALBUM));
		AlbumProxy proxy = target.proxy(AlbumProxy.class);
		Album resp = proxy.crearAlbum(album);
		return resp;
	}
	
	public Album editarAlbum(Album album) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_ALBUM));
		AlbumProxy proxy = target.proxy(AlbumProxy.class);
		Album resp = proxy.editarAlbum(album);
		return resp;
	}
	
	public void eliminarAlbum(Integer id) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_ALBUM + "/" + id));
		AlbumProxy proxy = target.proxy(AlbumProxy.class);
		proxy.eliminarAlbum();
	}
}
