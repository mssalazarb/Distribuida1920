package com.distribuida.service;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HolaMundoServiceImpl implements HolaMundoService{

	@Override
	public String hola() {
		return "HOLA MUNDO " + new Date();
	}
}
