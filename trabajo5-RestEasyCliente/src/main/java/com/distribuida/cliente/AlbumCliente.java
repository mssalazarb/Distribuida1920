package com.distribuida.cliente;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.constante.Constantes;
import com.distribuida.dto.Album;
import com.distribuida.dto.Singer;

public class AlbumCliente {
	
	private ResteasyClient client = new ResteasyClientBuilder().build();

	public String getAlbums() {
		ResteasyWebTarget getDummy = client.target(Constantes.URL_ALBUMS);
		Response getDummyResponse = getDummy.request().get();
		String value = getDummyResponse.readEntity(String.class);
		getDummyResponse.close();
		return value;
	}

	public String getAlbumPorId(Integer id) {
		ResteasyWebTarget getDummy = client.target(Constantes.URL_ALBUMS + "/" + id);
		Response getDummyResponse = getDummy.request().get();
		String value = getDummyResponse.readEntity(String.class);
		getDummyResponse.close();
		return value;
	}

	public void eliminarAlbum(Integer id) {
		ResteasyWebTarget delete = client.target(Constantes.URL_ALBUMS + "/" + id);
		Response deleteResponse = delete.request().delete();
		deleteResponse.close();
	}

	public String crearAlbum(Album album) {
		String resp = "";
		ResteasyWebTarget add = client.target(Constantes.URL_ALBUMS);
		Response addResponse = add.request().post(Entity.entity(album, "application/json"));
		resp = addResponse.readEntity(String.class);
		addResponse.close();
		return resp;
	}
	
	public String updateAlbum(Album album) {
		String resp = "";
		ResteasyWebTarget add = client.target(Constantes.URL_ALBUMS);
		Response addResponse = add.request().put(Entity.entity(album, "application/json"));
		resp = addResponse.readEntity(String.class);
		addResponse.close();
		return resp;
	}
}
