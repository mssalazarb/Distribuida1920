package com.distribuida.service;

import java.util.List;

import com.distribuida.dto.Singer;

public interface SingerService {

	Singer guardar(Singer singer);
	
	Singer editar(Singer singer);
	
	void eliminar(Integer id);
	
	Singer buscarPorId(Integer id);
	
	List<Singer> listarTodos();
}
