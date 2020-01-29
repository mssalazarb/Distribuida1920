package com.distribuida.conf;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class ApplicationEntityManager {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("examen01");
	
	@Produces
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
