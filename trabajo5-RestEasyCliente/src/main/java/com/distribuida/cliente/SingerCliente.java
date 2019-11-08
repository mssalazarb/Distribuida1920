package com.distribuida.cliente;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.constante.Constantes;
import com.distribuida.dto.Singer;

public class SingerCliente {

	private ResteasyClient client = new ResteasyClientBuilder().build();

	public String getSingers() {
		ResteasyWebTarget getDummy = client.target(Constantes.URL_SINGER);
		Response getDummyResponse = getDummy.request().get();
		String value = getDummyResponse.readEntity(String.class);
		getDummyResponse.close();
		return value;
	}

	public String getSingerPorId(Integer id) {
		ResteasyWebTarget getDummy = client.target(Constantes.URL_SINGER + "/" + id);
		Response getDummyResponse = getDummy.request().get();
		String value = getDummyResponse.readEntity(String.class);
		getDummyResponse.close();
		return value;
	}

	public void eliminarSinger(Integer id) {
		ResteasyWebTarget delete = client.target(Constantes.URL_SINGER + "/" + id);
		Response deleteResponse = delete.request().delete();
		deleteResponse.close();
	}

	public String crearSinger(Singer singer) {
		String resp = "";
		ResteasyWebTarget add = client.target(Constantes.URL_SINGER);
		Response addResponse = add.request().post(Entity.entity(singer, MediaType.APPLICATION_JSON));
		resp = addResponse.readEntity(String.class);
		addResponse.close();
		return resp;
	}
	
	public String updateSinger(Singer singer) {
		String resp = "";
		ResteasyWebTarget add = client.target(Constantes.URL_SINGER);
		Response addResponse = add.request().put(Entity.entity(singer, MediaType.APPLICATION_JSON));
		resp = addResponse.readEntity(String.class);
		addResponse.close();
		return resp;
	}
}
