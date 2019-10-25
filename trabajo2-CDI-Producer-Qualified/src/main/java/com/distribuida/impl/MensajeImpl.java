package com.distribuida.impl;

import javax.enterprise.context.ApplicationScoped;

import com.distribuida.servicios.Mensaje;

@ApplicationScoped
public class MensajeImpl implements Mensaje{

	public void imprimir(String mensaje, Object...params) {
		String format = String.format("[LOG] - %s\n", mensaje);
		System.out.printf(format, params);
	}
}
