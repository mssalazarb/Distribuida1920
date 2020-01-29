package com.distribuida.servicio;

import java.util.List;

import com.distribuida.dto.Singer;

public interface SingerService {
	
	Singer buscarPorId(Integer id);
	
	List<Singer> listarTodos();
}
