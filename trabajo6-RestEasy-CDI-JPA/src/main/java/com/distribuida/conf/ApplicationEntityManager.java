package com.distribuida.conf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationEntityManager {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabajo6");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
