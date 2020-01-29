package com.distribuida.servicio;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.dto.Album;

@ApplicationScoped
public class AlbumServiceImpl implements AlbumService{
	
	@Inject private EntityManager em;

	@Override
	public Album buscarPorId(Integer id) {
		List<Album> singers;
		singers = em.createQuery("SELECT u FROM Album u WHERE id = :id", Album.class).setParameter("id", id).getResultList();
		return singers.get(0);
	}

	@Override
	public List<Album> listarTodos() {
		List<Album> albums;
		albums = em.createQuery("SELECT u FROM Album u", Album.class).getResultList();
		return albums;
	}
}
