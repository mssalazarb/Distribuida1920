package com.distribuida.servicios;

public interface Mensaje {
	
	//Los 3 puntos son igual a [], es decir que podemos
	//recibir 1,2 o mas parametros pero por lo menos siempre
	//recibiremos un parametro
	void imprimir(String mensaje, Object...params);

}
