package com.distribuida.conexion;

import java.util.List;

public interface Persistencia {

	void crear(Object object);
	
	void editar(Object object);
	
	void eliminar(Integer id);
	
	<T> List<T> listar();
	
	Object buscarPorId(Integer id);
	
}
