package com.distribuida.helidon;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/")
public class ServidorApp extends Application{
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> red = new HashSet<>();
		red.add(SingerRest.class);
		return red;
//	JAVA 11	return Set.of(SingerRest.class);
	}
}
