package net.rodrigobrito.agenda.dao;

import java.util.List;

public interface GenericDAO<T> {
	public T find(long id);
	public void save(T entity);
	public void update(T entity);
	public void remove(long id);
	public List<T> findAll();
}
