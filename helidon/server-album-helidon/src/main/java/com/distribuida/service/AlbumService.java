package com.distribuida.service;

import java.util.List;

import com.distribuida.dto.Album;

public interface AlbumService {

	Album guardar(Album album);
	
	Album editar(Album album);
	
	void eliminar(Integer id);
	
	Album buscarPorId(Integer id);
	
	List<Album> listarTodos();
}
