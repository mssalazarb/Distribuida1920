package com.distribuida.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.distribuida.dto.Album;

@Dependent
public class AlbumServiceImpl implements AlbumService{
	
	@Inject
	private SessionFactory em;
	
	private Transaction transaction;

	@Override
	public Album guardar(Album album) {
		Session s = em.openSession();
		transaction =  s.beginTransaction();
		s.save(album);
		transaction.commit();
		return album;
	}

	@Override
	public Album editar(Album album) {
		Session s = em.openSession();
		transaction =  s.beginTransaction();
		s.merge(album);
		transaction.commit();
		return album;
	}

	@Override
	public void eliminar(Integer id) {
		Session s = em.openSession();
		transaction =  s.beginTransaction();
		Album album = s.createQuery("FROM Album u WHERE id = :id", Album.class).setParameter("id", id).getResultList().get(0);
		s.remove(album);
		transaction.commit();
	}

	@Override
	public Album buscarPorId(Integer id) {
		List<Album> albums;
		Session s = em.openSession();
		albums = s.createQuery("SELECT u FROM Album u WHERE id = :id", Album.class).setParameter("id", id).getResultList();
		return albums.get(0);
	}

	@Override
	public List<Album> listarTodos() {
		List<Album> albums;
		Session s = em.openSession();
		albums = s.createQuery("FROM Album", Album.class).list();
		return albums;
	}
}
