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
		model.addAttribute("title", "Agenda de Contatos");
		model.addAttribute("contatos", contatoDAO.findAll());
		return "listar";
	}
	
	@RequestMapping("/cadastrar")
	public String cadastrar(Model model){
		model.addAttribute("title", "Cadastrar contato");
		return "cadastrar";
	}
	
	@RequestMapping("/salvar")
	public String salvar(Model model, @Valid Contato contato, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("error", "Dados inválidos, por favor verifique os valores.");
			return "cadastrar";
		}
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.save(contato);
		model.addAttribute("message", "Contato cadastrado com sucesso!");
		return "redirect:listar";
	}
	
	@RequestMapping("/editar")
	public String editar(long id, Model model){
		ContatoDAO contatoDAO = new ContatoDAO();
		Contato contato = contatoDAO.find(id);
		if(contato  == null){
			model.addAttribute("error", "Contato inexistente!");
			return "listar";
		}
		model.addAttribute("contato", contato);
		model.addAttribute("title", "Editar Contato");
		return "editar";
	}
	
	@RequestMapping("/atualizar")
	public String atualizar(@Valid Contato contato, Model model, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("title", "Editar contato");
			model.addAttribute("contato", contato);
			return "editar";
		}
		model.addAttribute("message", "Contato atualizado com sucesso");
		return "listar";
	}
	
	@RequestMapping("/excluir")
	public String excluir(long id, Model model){
		ContatoDAO contatoDAO = new ContatoDAO();
		try {
			contatoDAO.remove(id);
			model.addAttribute("message", "Contato removido com sucesso");
		} catch (Exception e) {
			model.addAttribute("error", "Erro ao excluir contato");
			e.printStackTrace();
		}
		return "redirect:listar";
	}
}
