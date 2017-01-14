package net.rodrigobrito.agenda.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory entityManagerFactory;
	private JPAUtil(){ }
	public static EntityManager getEntityManager(){
		if(entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory("agenda");
		}
		return entityManagerFactory.createEntityManager();
	}
}