package com.distribuida.main;

import javax.enterprise.inject.spi.CDI;

import org.jboss.weld.environment.se.Weld;

import com.distribuida.servicios.Operaciones;

public class PrincipalCdi {
	
	public static void main(String[] args) {
		
		/*AMBIGUEDAD
		 * 1. Existe un OperacionesImpl que implementa la interface 
		 * 2. Existe un Factory con @Produces que retorna la implementacion
		*/
		
		/*SOLUCION AMBIGUEDAD
		 * 1. Se debe crear un @interface OperacionesProducer con
		 *	@Qualifier
		 *	@Retention(RetentionPolicy.RUNTIME)
		 *	@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
		 *
		 *2. En OperacionesImpl anotamos la clase como @OperacionesProducer
		 *	 de esta forma el contenedor resuelve la ambiguedad
		 * */
		
		CDI<Object> cdi = new Weld().initialize();
		Operaciones service = cdi.select(Operaciones.class).get();
		int resultado = service.sumar(4, 5);
		
		System.out.printf("Respuesta: %d\n", resultado);
	}

}
