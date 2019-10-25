package com.distribuida.impl;

import javax.enterprise.inject.spi.CDI;

import com.distribuida.producer.OperacionesProducer;
import com.distribuida.servicios.Mensaje;
import com.distribuida.servicios.Operaciones;

@OperacionesProducer
public class OperacionesImpl implements Operaciones{
	
	Mensaje mensaje = CDI.current().select(Mensaje.class).get();
	
	public int sumar(int a, int b) {
		
		String res = "Sumando: " + a + "+" + b;
		mensaje.imprimir(res);
	
		int respuesta = a + b;
		String res_1 = "Resultado: " + respuesta;
		mensaje.imprimir(res_1);
		
		return respuesta;
	}
}
