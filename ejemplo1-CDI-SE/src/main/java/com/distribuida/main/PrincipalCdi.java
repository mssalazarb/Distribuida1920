package com.distribuida.main;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import com.distribuida.servicios.Operaciones;

public class PrincipalCdi {

	public static void main(String[] args) {
		
		//Inicializamos el contenedor Weld de CDI
		SeContainer container = SeContainerInitializer
				.newInstance()
				.initialize();
		
		//Obtenemos la instancia de la implementacion de Operaciones
		Instance<Operaciones> obj = container.select(Operaciones.class);
		
		Operaciones servicio = obj.get();
		
		//Ahora podemos acceder a los metodos de Operaciones
		int resultado = servicio.sumar(4, 5);
		
		System.out.printf("Respuesta: %d\n", resultado);

	}

}
