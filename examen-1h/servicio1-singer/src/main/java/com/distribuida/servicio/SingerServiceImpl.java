package com.distribuida.servicio;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.distribuida.dto.Singer;

@ApplicationScoped
public class SingerServiceImpl implements SingerService{
	
	@Inject private EntityManager em;

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
