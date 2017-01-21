package net.rodrigobrito.agenda.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import net.rodrigobrito.agenda.util.JPAUtil;

public class AbstractDAO<T>{
	protected EntityManager entityManager;
	private Class<T> entityClass;

	public AbstractDAO() {
		entityManager = JPAUtil.getEntityManager();
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	public T find(long id) {
		return entityManager.find(entityClass, id);
	}

	public void save(T entity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(entity);
		this.entityManager.getTransaction().commit();
	}

	public void update(@Valid T entity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(entity);
		this.entityManager.flush();
		this.entityManager.getTransaction().commit();
	}

	public void remove(long id) {
		this.entityManager.getTransaction().begin();
		T entity = entityManager.getReference(entityClass, id);
		this.entityManager.remove(entity);
		this.entityManager.getTransaction().commit();
	}
}
