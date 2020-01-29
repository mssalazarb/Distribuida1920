package com.distribuida.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.distribuida.dto.Singer;

@Dependent
public class SingerServiceImpl implements SingerService{
	
	@Inject
	private SessionFactory em;
	
	private Transaction transaction;

	@Override
	public Singer guardar(Singer singer) {
		Session s = em.openSession();
		transaction =  s.beginTransaction();
		s.save(singer);
		transaction.commit();
		return singer;
	}

	@Override
	public Singer editar(Singer singer) {
		Session s = em.openSession();
		transaction =  s.beginTransaction();
		s.merge(singer);
		transaction.commit();
		return singer;
	}

	@Override
	public void eliminar(Integer id) {
		Session s = em.openSession();
		transaction =  s.beginTransaction();
		Singer singer = s.createQuery("FROM Singer u WHERE id = :id", Singer.class).setParameter("id", id).getResultList().get(0);
		s.remove(singer);
		transaction.commit();
	}

	@Override
	public Singer buscarPorId(Integer id) {
		List<Singer> singers;
		Session s = em.openSession();
		singers = s.createQuery("SELECT u FROM Singer u WHERE id = :id", Singer.class).setParameter("id", id).getResultList();
		return singers.get(0);
	}

	@Override
	public List<Singer> listarTodos() {
		List<Singer> singers;
		Session s = em.openSession();
		singers = s.createQuery("FROM Singer", Singer.class).list();
		return singers;
	}
}
