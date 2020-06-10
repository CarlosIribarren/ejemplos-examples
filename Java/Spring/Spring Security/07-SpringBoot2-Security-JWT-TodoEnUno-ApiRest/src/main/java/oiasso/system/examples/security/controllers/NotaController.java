package oiasso.system.examples.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oiasso.system.examples.security.entitys.Nota;
import oiasso.system.examples.security.facades.NotaFacade;

@RestController
@RequestMapping("/nota")
public class NotaController {

	@Autowired
	private NotaFacade notaFacade; 
	
	@GetMapping("/all")
	public ResponseEntity<List<Nota>> getAll(Model modelo) {
		
		List<Nota> notas = notaFacade.getAll();
		ResponseEntity<List<Nota>> response = new ResponseEntity<List<Nota>>(notas, HttpStatus.ACCEPTED);
		return response;
	}

}