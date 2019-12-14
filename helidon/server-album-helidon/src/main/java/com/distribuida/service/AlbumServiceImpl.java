package com.distribuida.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.dto.Album;

@Dependent
public class AlbumServiceImpl implements AlbumService{
	
	@Inject
	private EntityManager em;

	@Override
	public Album guardar(Album singer) {
		em.getTransaction().begin();
		em.persist(singer);
		em.getTransaction().commit();
		return singer;
	}

	@Override
	public Album editar(Album singer) {
		em.getTransaction().begin();
		em.merge(singer);
		em.getTransaction().commit();
		return singer;
	}

	@Override
	public void eliminar(Integer id) {
		em.getTransaction().begin();
		Album singer = em.createQuery("SELECT u FROM Album u WHERE id = :id", Album.class).setParameter("id", id).getResultList().get(0);
		em.remove(singer);
		em.getTransaction().commit();
	}

	@Override
	public Album buscarPorId(Integer id) {
		List<Album> singers;
		singers = em.createQuery("SELECT u FROM Album u WHERE id = :id", Album.class).setParameter("id", id).getResultList();
		return singers.get(0);
	}

	@Override
	public List<Album> listarTodos() {
		List<Album> singers;
		singers = em.createQuery("SELECT u FROM Album u", Album.class).getResultList();
		return singers;
	}
}
