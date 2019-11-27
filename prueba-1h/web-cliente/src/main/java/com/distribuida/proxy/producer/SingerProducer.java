package com.distribuida.proxy.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxy.SingerProxy;

@ApplicationScoped
public class SingerProducer {

	private static final String URL_SINGER = "http://127.0.0.1:8080/servidor1-singer/singers";
	
	@Produces
	public SingerProxy servicioSinger( ) {
		ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = client.target(URL_SINGER);
		return target.proxy(SingerProxy.class);
	}
}
