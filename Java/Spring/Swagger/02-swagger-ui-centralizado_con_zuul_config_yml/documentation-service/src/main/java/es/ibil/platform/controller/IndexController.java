package es.ibil.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@ApiIgnore
public class IndexController {

	@GetMapping(value = "/")
	public String index() {
		return "redirect:/swagger-ui.html";
	}
}