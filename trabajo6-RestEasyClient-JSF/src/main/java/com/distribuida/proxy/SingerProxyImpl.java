package com.distribuida.proxy;

import java.util.List;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.dto.Singer;

public class SingerProxyImpl {

	private static final String URL_SINGER = "http://127.0.0.1:8080/trabajo6-RestEasy-CDI-JPA/singers";
	
	public List<Singer> listarTodos(){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SINGER));
		SingerProxy proxy = target.proxy(SingerProxy.class);
		return proxy.listarTodos();
	}
	
	public Singer crearSinger(Singer singer) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SINGER));
		SingerProxy proxy = target.proxy(SingerProxy.class);
		Singer resp = proxy.crearSinger(singer);
		return resp;
	}
	
	public Singer editarSinger(Singer singer) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SINGER));
		SingerProxy proxy = target.proxy(SingerProxy.class);
		Singer resp = proxy.editarSinger(singer);
		return resp;
	}
	
	public void eliminarSinger(Integer id) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SINGER + "/" + id));
		SingerProxy proxy = target.proxy(SingerProxy.class);
		proxy.eliminarSinger();
	}
}
