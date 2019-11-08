package com.distribuida.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.distribuida.rest.AlbumRest;
import com.distribuida.rest.SingerRest;

@ApplicationPath("")
public class BasedApplication extends Application{
	
	private Set<Object> singletons = new HashSet<Object>();

	public BasedApplication() {
		singletons.add(new SingerRest());
		singletons.add(new AlbumRest());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
