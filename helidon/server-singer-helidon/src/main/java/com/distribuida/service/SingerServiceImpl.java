package com.distribuida.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.dto.Singer;

@Dependent
public class SingerServiceImpl implements SingerService{
	
	@Inject
	private EntityManager em;

	@Override
	public Singer guardar(Singer singer) {
		em.getTransaction().begin();
		em.persist(singer);
		em.getTransaction().commit();
		return singer;
	}

	@Override
	public Singer editar(Singer singer) {
		em.getTransaction().begin();
		em.merge(singer);
		em.getTransaction().commit();
		return singer;
	}

	@Override
	public void eliminar(Integer id) {
		em.getTransaction().begin();
		Singer singer = em.createQuery("SELECT u FROM Singer u WHERE id = :id", Singer.class).setParameter("id", id).getResultList().get(0);
		em.remove(singer);
		em.getTransaction().commit();
	}

	@Override
	public Singer buscarPorId(Integer id) {
		List<Singer> singers;
		singers = em.createQuery("SELECT u FROM Singer u WHERE id = :id", Singer.class).setParameter("id", id).getResultList();
		return singers.get(0);
	}

	@Override
	public List<Singer> listarTodos() {
		List<Singer> singers;
		singers = em.createQuery("SELECT u FROM Singer u", Singer.class).getResultList();
		return singers;
	}
}
