package com.distribuida.servicio;

import java.util.List;

import com.distribuida.dto.Album;

public interface AlbumService {
	
	Album buscarPorId(Integer id);
	
	List<Album> listarTodos();
}
