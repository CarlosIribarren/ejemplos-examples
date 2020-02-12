package oiasso.system.examples.jpa.datatables.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oiasso.system.examples.jpa.datatables.helpers.FiltroPersonas;

@Controller
public class PersonasController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String inicio(Model model) {
		model.addAttribute("filtroPersonas", new FiltroPersonas());
		return "inicio";
	}

}
