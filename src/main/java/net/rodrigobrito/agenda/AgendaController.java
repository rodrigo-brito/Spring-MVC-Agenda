package net.rodrigobrito.agenda;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.rodrigobrito.agenda.dao.ContatoDAO;
import net.rodrigobrito.agenda.model.Contato;

@Controller
public class AgendaController {
	@RequestMapping("/")
	public String index(Model model){
		return "redirect:listar";
	}
	
	@RequestMapping("/listar")
	public String teste(Model model){
		ContatoDAO contatoDAO = new ContatoDAO();
		model.addAttribute("contatos", contatoDAO.findAll());
		return "listar";
	}
	
	@RequestMapping("/listar")
	public String salvar(Model model, @Valid Contato contato, BindingResult result){
		if(result.hasErrors()){
			return "cadastrar";
		}
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.save(contato);
		model.addAttribute("message", "Contato cadastrado com sucesso!");
		return "listar";
	}
}
