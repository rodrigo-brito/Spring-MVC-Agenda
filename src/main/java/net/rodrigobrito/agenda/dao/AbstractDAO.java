package net.rodrigobrito.agenda.dao;

import javax.persistence.EntityManager;

import net.rodrigobrito.agenda.util.JPAUtil;

public class AbstractDAO<T> {
	protected EntityManager em;
	public AbstractDAO(){
		em = JPAUtil.getEntityManager();
	}
	public void save(T obj){
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}
}
