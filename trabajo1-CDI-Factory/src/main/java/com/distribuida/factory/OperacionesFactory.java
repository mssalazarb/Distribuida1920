package com.distribuida.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.distribuida.impl.OperacionesImpl;
import com.distribuida.servicios.Operaciones;

@ApplicationScoped
public class OperacionesFactory {

	@Produces
	public Operaciones instance() {
		return new OperacionesImpl();
	}
}
