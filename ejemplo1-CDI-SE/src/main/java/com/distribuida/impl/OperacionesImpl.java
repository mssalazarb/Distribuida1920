package com.distribuida.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.servicios.Mensaje;
import com.distribuida.servicios.Operaciones;

//Implementacion de Weld con Lookup porque el servicio Operaciones 
//va a ser accedido desde fuera

@ApplicationScoped

//Named se coloca para evitar la ambiguedad por si acaso exista otro 
//servicio que implemente la misma interfaz, si existe ambiguedad se 
//utiliza el Qualified de esta implementacion
@Named("operaciones")
public class OperacionesImpl implements Operaciones{
	
	//Implementamos DI porque el servicio Mensaje va a ser accedido desde 
	//dentro
	
	//Inject nos permite obtener la instancia de Mensaje
	@Inject 
	private Mensaje mensaje;
	
	public int sumar(int a, int b) {
		
		String res = "Sumando: " + a + "+" + b;
		mensaje.imprimir(res);
		
		int respuesta = a + b;
		String res_1 = "Resultado: " + respuesta;
		mensaje.imprimir(res_1);
		
		return respuesta;
	}
}
