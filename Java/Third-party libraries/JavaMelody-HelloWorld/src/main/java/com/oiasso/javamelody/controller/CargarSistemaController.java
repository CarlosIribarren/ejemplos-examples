package com.oiasso.javamelody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CargarSistemaController {

    @RequestMapping("/cargar-sistema")
    public void cargarSistema() {
         
        // Metodo para cargar un poco el sisetma
        for(Integer a = 0 ; a < 100000000 ; a++) {
        	
        	String cadena = new String();
        	cadena = a.toString();        	
        	System.out.println("Numero" + cadena);
        }
    	
    }
	
}
