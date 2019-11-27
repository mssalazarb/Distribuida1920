package com.distribuida.service;

import java.util.List;

import com.distribuida.dto.Album;

public interface AlbumService {

	Album crear(Album album);
	
	Album editar(Album album);
	
	void eliminar(Integer id);
	
	List<Album> listar();
	
	Album buscarPorId(Integer id);
}
