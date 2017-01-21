package net.rodrigobrito.agenda.dao;

import java.util.List;

import net.rodrigobrito.agenda.model.Contato;

public class ContatoDAO extends AbstractDAO<Contato> implements GenericDAO<Contato>{
	@Override
	public List<Contato> findAll() {
		return super.entityManager.createQuery("from Contato").getResultList();
	}
}
