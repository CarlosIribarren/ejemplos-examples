package oiasso.system.examples.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	  // Login form
	  @GetMapping("/login")
	  public String login() {
	    return "login.html";
	  }
	
}
