package com.distribuida.service;

import java.util.List;

import com.distribuida.dto.Singer;

public interface SingerService {

	Singer crear(Singer singer);
	
	Singer editar(Singer singer);
	
	void eliminar(Integer id);
	
	List<Singer> listar();
	
	Singer buscarPorId(Integer id);
}
