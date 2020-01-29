package com.distribuida.servicio;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.dto.Instrument;

@ApplicationScoped
public class InstrumentServiceImpl implements InstrumentService{
	
	@Inject private EntityManager em;

	@Override
	public Instrument buscarPorId(Integer id) {
		List<Instrument> singers;
		singers = em.createQuery("SELECT u FROM Instrument u WHERE id = :id", Instrument.class).setParameter("id", id).getResultList();
		return singers.get(0);
	}

	@Override
	public List<Instrument> listarTodos() {
		List<Instrument> singers;
		singers = em.createQuery("SELECT u FROM Instrument u", Instrument.class).getResultList();
		return singers;
	}
}
