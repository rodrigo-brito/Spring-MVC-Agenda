package net.rodrigobrito.agenda;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.rodrigobrito.agenda.dao.ContatoDAO;
import net.rodrigobrito.agenda.model.Contato;

public class ContatoDaoTest {
	
	private ContatoDAO contatoDAO;
	private long lastId;
	
	@Before
	public void before() {
		contatoDAO = new ContatoDAO();
		List<Contato> contatos = contatoDAO.findAll();
		lastId = contatos.get( contatos.size() - 1 ).getId();
	}

	@Test
	public void save() {
		Contato contato = new Contato("Rodrigo", "1231-1231", "email@email.com.br");
		contatoDAO.save(contato);
		Contato contatoSearch = contatoDAO.find(contato.getId());
		assertNotNull(contatoSearch);
	}
	
	@Test
	public void update() {
		Contato contato = contatoDAO.find(lastId);
		contato.setNome("Pedro");
		contatoDAO.update(contato);
		Contato contatoSearch = contatoDAO.find(lastId);
		assertEquals(contatoSearch.getNome(), "Pedro");
	}
	
	@Test
	public void remove() {
		contatoDAO.remove(this.lastId);
		Contato contatoSearch = contatoDAO.find(this.lastId);
		assertNull(contatoSearch);
	}
}
