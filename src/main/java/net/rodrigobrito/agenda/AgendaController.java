package net.rodrigobrito.agenda;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgendaController {
	@RequestMapping("/hello")
	public String teste(Model model){
		model.addAttribute("message", "Hello World");
		return "hello";
	}

}
