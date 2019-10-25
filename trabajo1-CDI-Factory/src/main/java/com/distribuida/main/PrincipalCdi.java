package com.distribuida.main;

import javax.enterprise.inject.spi.CDI;

import org.jboss.weld.environment.se.Weld;

import com.distribuida.factory.OperacionesFactory;
import com.distribuida.servicios.Operaciones;

public class PrincipalCdi {

	public static void main(String[] args) {
		
		/*FACTORY FUNCIONA Lookup
		  1. Mensaje no tiene anotacion por ser interface
		  2. MensajeImpl debe ser @ApplicationScoped
		  3. Operaciones y OperacionesImpl no deben tener anotaciones
		  4. OperacionesFactory debe tener @ApplicationScoped y @Produces
		  5. Main:*/ 
		
		CDI<Object> cdi = new Weld().initialize();
		OperacionesFactory factory = cdi.select(OperacionesFactory.class).get();
		Operaciones service = factory.instance();
		int resultado = service.sumar(4, 5);
		System.out.printf("Respuesta: %d\n", resultado);	
	}

}
