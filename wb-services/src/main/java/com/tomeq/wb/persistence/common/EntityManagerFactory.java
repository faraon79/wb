package com.tomeq.wb.persistence.common;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {

	public EntityManager getEntityManager() {
		javax.persistence.EntityManagerFactory emf = Persistence.createEntityManagerFactory("wb-pu");
		return emf.createEntityManager();
	}
}
